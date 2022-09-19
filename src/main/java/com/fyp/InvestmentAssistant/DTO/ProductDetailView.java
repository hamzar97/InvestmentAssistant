package com.fyp.InvestmentAssistant.DTO;

public class ProductDetailView {
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private int CATEGORY_ID;
    private int PRODUCT_SALES;
    private String PRODUCT_DESC;
    private String MSTRATEGY;
    private int PRODUCTDETAIL_ID;
    private int VENDOR_ID;
    private int MIN_ORDER;
    private int PERUNITPRICE;
    private String VENDOR_NAME;
    private String ADDRESS;
    private String PHONE_NO;
    private String VENDOR_PICTURE;

    public ProductDetailView(int PRODUCT_ID, String PRODUCT_NAME, int CATEGORY_ID, int PRODUCT_SALES, String PRODUCT_DESC, String MSTRATEGY, int PRODUCTDETAIL_ID, int VENDOR_ID, int MIN_ORDER, int PERUNITPRICE, String VENDOR_NAME, String ADDRESS, String PHONE_NO, String VENDOR_PICTURE) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.CATEGORY_ID = CATEGORY_ID;
        this.PRODUCT_SALES = PRODUCT_SALES;
        this.PRODUCT_DESC = PRODUCT_DESC;
        this.MSTRATEGY = MSTRATEGY;
        this.PRODUCTDETAIL_ID = PRODUCTDETAIL_ID;
        this.VENDOR_ID = VENDOR_ID;
        this.MIN_ORDER = MIN_ORDER;
        this.PERUNITPRICE = PERUNITPRICE;
        this.VENDOR_NAME = VENDOR_NAME;
        this.ADDRESS = ADDRESS;
        this.PHONE_NO = PHONE_NO;
        this.VENDOR_PICTURE = VENDOR_PICTURE;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public int getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(int CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public int getPRODUCT_SALES() {
        return PRODUCT_SALES;
    }

    public void setPRODUCT_SALES(int PRODUCT_SALES) {
        this.PRODUCT_SALES = PRODUCT_SALES;
    }

    public String getPRODUCT_DESC() {
        return PRODUCT_DESC;
    }

    public void setPRODUCT_DESC(String PRODUCT_DESC) {
        this.PRODUCT_DESC = PRODUCT_DESC;
    }

    public String getMSTRATEGY() {
        return MSTRATEGY;
    }

    public void setMSTRATEGY(String MSTRATEGY) {
        this.MSTRATEGY = MSTRATEGY;
    }

    public int getPRODUCTDETAIL_ID() {
        return PRODUCTDETAIL_ID;
    }

    public void setPRODUCTDETAIL_ID(int PRODUCTDETAIL_ID) {
        this.PRODUCTDETAIL_ID = PRODUCTDETAIL_ID;
    }

    public int getVENDOR_ID() {
        return VENDOR_ID;
    }

    public void setVENDOR_ID(int VENDOR_ID) {
        this.VENDOR_ID = VENDOR_ID;
    }

    public int getMIN_ORDER() {
        return MIN_ORDER;
    }

    public void setMIN_ORDER(int MIN_ORDER) {
        this.MIN_ORDER = MIN_ORDER;
    }

    public int getPERUNITPRICE() {
        return PERUNITPRICE;
    }

    public void setPERUNITPRICE(int PERUNITPRICE) {
        this.PERUNITPRICE = PERUNITPRICE;
    }

    public String getVENDOR_NAME() {
        return VENDOR_NAME;
    }

    public void setVENDOR_NAME(String VENDOR_NAME) {
        this.VENDOR_NAME = VENDOR_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPHONE_NO() {
        return PHONE_NO;
    }

    public void setPHONE_NO(String PHONE_NO) {
        this.PHONE_NO = PHONE_NO;
    }

    public String getVENDOR_PICTURE() {
        return VENDOR_PICTURE;
    }

    public void setVENDOR_PICTURE(String VENDOR_PICTURE) {
        this.VENDOR_PICTURE = VENDOR_PICTURE;
    }
}
