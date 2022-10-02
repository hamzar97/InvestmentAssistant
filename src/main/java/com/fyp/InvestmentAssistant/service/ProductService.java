package com.fyp.InvestmentAssistant.service;

import com.fyp.InvestmentAssistant.DTO.ProductDetailView;
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

        Set<Integer> ProductId=new HashSet<>();
        String finalProducts="";
        long finalResult=0;
        String sql="select PRODUCT_ID,PRODUCT_NAME,CATEGORY_ID,PRODUCT_SALES,PRODUCT_DESC,MSTRATEGY,PRODUCTDETAIL_ID,VENDOR_ID,MIN_ORDER,PERUNITPRICE,VENDOR_NAME,ADDRESS,PHONE_NO,VENDOR_PICTURE from ProductDetailsView WHERE CATEGORY_ID = ?;";
        List<ProductDetailView> pdv=jdbcTemplate.query(sql,new ProductDetailRowMapper(),categoryId);
        for(ProductDetailView prod: pdv){
            finalResult=budget/prod.getPERUNITPRICE();
            if(finalResult>=prod.getMIN_ORDER()){
                    ProductId.add(prod.getPRODUCT_ID());
            }
        }

        for(Integer selectedProducts:ProductId){
            finalProducts=finalProducts+selectedProducts+",";
        }
        finalProducts=finalProducts.substring(0,finalProducts.length()-1);

        return productRepository.findProductsByBulk(finalProducts);
    }

    public List<Vendor> getVendorsList(){
        return null;
    }
}
