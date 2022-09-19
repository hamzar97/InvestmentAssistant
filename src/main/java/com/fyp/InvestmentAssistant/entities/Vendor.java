package com.fyp.InvestmentAssistant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    private Long vendorId;

    @Column(name="VENDOR_NAME")
    private String vendorName;
    @Column(name="ADDRESS")
    private String vendorAddress;
    @Column(name="PHONE_NO")
    private String phoneNo;
    @Column(name="VENDOR_PICTURE")
    private String vendorPicture;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
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
}
