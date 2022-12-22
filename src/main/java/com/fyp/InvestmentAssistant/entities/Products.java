package com.fyp.InvestmentAssistant.entities;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Products{
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Column(name = "PRODUCT_SALES")
    private long productSales;
    @Column(name = "PRODUCT_DESC")
    private String productDesc;
    @Column(name = "MSTRATEGY")
    private String mStrategy;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getProductSales() {
        return productSales;
    }

    public void setProductSales(long productSales) {
        this.productSales = productSales;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getmStrategy() {
        return mStrategy;
    }

    public void setmStrategy(String mStrategy) {
        this.mStrategy = mStrategy;
    }

}
