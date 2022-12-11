package com.fyp.InvestmentAssistant.service;

import com.fyp.InvestmentAssistant.DTO.ProductDetailView;
import com.fyp.InvestmentAssistant.DTO.VendorDetailsAndParams;
import com.fyp.InvestmentAssistant.entities.*;
import com.fyp.InvestmentAssistant.model.ProductDetailRowMapper;
import com.fyp.InvestmentAssistant.repository.CategoryRepository;
import com.fyp.InvestmentAssistant.repository.ProductRepository;
import com.fyp.InvestmentAssistant.repository.UserRepository;
import com.fyp.InvestmentAssistant.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    JavaMailSender javaMailSender;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Products> getProducts(long userId,int categoryId,long budget){

        Set<Integer> productIds=new HashSet<>();
        String finalProducts="";
        long finalResult=0;
        String sql="select PRODUCT_ID,PRODUCT_NAME,CATEGORY_ID,PRODUCT_SALES,PRODUCT_DESC,MSTRATEGY,PRODUCTDETAIL_ID,VENDOR_ID,MIN_ORDER,PERUNITPRICE,VENDOR_NAME,ADDRESS,PHONE_NO,VENDOR_PICTURE from ProductDetailsView WHERE CATEGORY_ID = ?;";
        List<ProductDetailView> pdv=jdbcTemplate.query(sql,new ProductDetailRowMapper(),categoryId);
        for(ProductDetailView prod: pdv){
            finalResult=budget/prod.getPERUNITPRICE();
            if(finalResult>=prod.getMIN_ORDER()){
                    productIds.add(prod.getPRODUCT_ID());
            }
        }

        //finalProducts=finalProducts.substring(0,finalProducts.length()-1);
        List<Products> productsList=productRepository.findAllById(productIds);
        Comparator<Products> compareBySales = Comparator.comparing(Products::getProductSales).reversed();
        Collections.sort(productsList,compareBySales);
        return productsList.subList(0,productsList.size());
//        return productRepository.findProductsByBulk(finalProducts);
    }

    public List<VendorDetailsAndParams> getVendorsList(int productId){
        List<VendorDetailsAndParams> vendorDetailsAndParamsList=new ArrayList<>();
        String sql="select PRODUCT_ID,PRODUCT_NAME,CATEGORY_ID,PRODUCT_SALES,PRODUCT_DESC,MSTRATEGY,PRODUCTDETAIL_ID,VENDOR_ID,MIN_ORDER,PERUNITPRICE,VENDOR_NAME,ADDRESS,PHONE_NO,VENDOR_PICTURE from ProductDetailsView WHERE PRODUCT_ID = ?;";
        List<ProductDetailView> pdv=jdbcTemplate.query(sql,new ProductDetailRowMapper(),productId);

        for(ProductDetailView prod: pdv){
            VendorDetailsAndParams vdap=new VendorDetailsAndParams();
            vdap.setVendorId(prod.getVENDOR_ID());
            vdap.setVendorName(prod.getVENDOR_NAME());
            vdap.setVendorAddress(prod.getADDRESS());
            vdap.setPhoneNo(prod.getPHONE_NO());
            vdap.setVendorPicture(prod.getVENDOR_PICTURE());
            vdap.setMinOrder(prod.getMIN_ORDER());
            vdap.setPerUnitPrice(prod.getPERUNITPRICE());
            vendorDetailsAndParamsList.add(vdap);
        }
        Comparator<VendorDetailsAndParams> compareByPerUnitPrice = Comparator.comparing(VendorDetailsAndParams::getPerUnitPrice);
        Collections.sort(vendorDetailsAndParamsList,compareByPerUnitPrice);
        return vendorDetailsAndParamsList;
    }

    public ProductDetailView getVendor(int vendorId,int productId){
        List<VendorDetailsAndParams> vendorDetailsAndParamsList=new ArrayList<>();
        String sql="select PRODUCT_ID,PRODUCT_NAME,CATEGORY_ID,PRODUCT_SALES,PRODUCT_DESC,MSTRATEGY,PRODUCTDETAIL_ID,VENDOR_ID,MIN_ORDER,PERUNITPRICE,VENDOR_NAME,ADDRESS,PHONE_NO,VENDOR_PICTURE from ProductDetailsView WHERE PRODUCT_ID = ? AND VENDOR_ID = ?;";
        List<ProductDetailView> pdv=jdbcTemplate.query(sql,new ProductDetailRowMapper(),productId,vendorId);
        ProductDetailView productDetailView=null;
        try{
            productDetailView=pdv.get(0);
        }catch(Exception e){

        }
        return productDetailView;
    }

    public boolean sendOrderEmail(Orders orders){
        boolean isEmailSent=true;
        Users users= userRepository.findByUserId((long)orders.getUserId());
        Products products=productRepository.findByProductId(orders.getProductId());
        Vendor vendor=vendorRepository.findByVendorId((long)orders.getVendorId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("investmentassistant@kawaiistore.pk");
        message.setTo(vendor.getVendorEmail());
        message.setSubject("ORDER RECIEVED: "+orders.getOrderId());
        message.setText("Order Recieved!\n " +
                "\nCustomer Name: " +users.getFullName()+
                "\nCustomer Email: " +users.getEmail()+
                "\nCustomer Phone No.: " +users.getPhoneNo()+
                "\nCustomer Address: " +users.getAddress()+
                "\n\nOrder ID: " +orders.getOrderId()+
                "\nOrder Quantity: " +orders.getTotalQuantity()+
                "\nOrder Total Amount: " +orders.getTotalPrice()+
                "\nProduct Name: " +products.getProductName().trim()+
                "\nProduct Per unit Price: " +orders.getPerUnitPrice()+
                "\n\nFrom \n\nInvestment Assistant");
        try {
            javaMailSender.send(message);
        }catch (Exception e){
            isEmailSent=false;
        }
        return isEmailSent;
    }
}
