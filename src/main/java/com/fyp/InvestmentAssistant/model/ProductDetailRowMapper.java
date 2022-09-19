package com.fyp.InvestmentAssistant.model;

import com.fyp.InvestmentAssistant.DTO.ProductDetailView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetailRowMapper implements RowMapper<ProductDetailView> {

    @Override
    public ProductDetailView mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductDetailView(
                rs.getInt("PRODUCT_ID"),
                rs.getString("PRODUCT_NAME"),
                rs.getInt("CATEGORY_ID"),
                rs.getInt("PRODUCT_SALES"),
                rs.getString("PRODUCT_DESC"),
                rs.getString("MSTRATEGY"),
                rs.getInt("PRODUCTDETAIL_ID"),
                rs.getInt("VENDOR_ID"),
                rs.getInt("MIN_ORDER"),
                rs.getInt("PERUNITPRICE"),
                rs.getString("VENDOR_NAME"),
                rs.getString("ADDRESS"),
                rs.getString("PHONE_NO"),
                rs.getString("VENDOR_PICTURE")
        );
    }

}
