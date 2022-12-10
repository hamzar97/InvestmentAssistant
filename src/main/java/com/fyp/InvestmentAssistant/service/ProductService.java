package com.fyp.InvestmentAssistant.service;

import com.fyp.InvestmentAssistant.DTO.ProductDetailView;
import com.fyp.InvestmentAssistant.DTO.VendorDetailsAndParams;
import com.fyp.InvestmentAssistant.entities.Category;
import com.fyp.InvestmentAssistant.entities.Products;
import com.fyp.InvestmentAssistant.entities.Vendor;
import com.fyp.InvestmentAssistant.model.ProductDetailRowMapper;
import com.fyp.InvestmentAssistant.repository.CategoryRepository;
import com.fyp.InvestmentAssistant.repository.ProductRepository;
import com.fyp.InvestmentAssistant.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    JdbcTemplate jdbcTemplate;

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
}
