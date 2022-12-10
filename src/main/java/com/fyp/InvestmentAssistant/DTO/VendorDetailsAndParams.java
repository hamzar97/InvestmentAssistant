package com.fyp.InvestmentAssistant.DTO;

public class VendorDetailsAndParams {


    private int vendorId;
    private String vendorName;
    private String vendorAddress;
    private String phoneNo;
    private String vendorPicture;
    private int minOrder;
    private int perUnitPrice;

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getVendorPicture() {
        return vendorPicture;
    }

    public void setVendorPicture(String vendorPicture) {
        this.vendorPicture = vendorPicture;
    }

    public int getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(int minOrder) {
        this.minOrder = minOrder;
    }

    public int getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(int perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }
}
