package com.fyp.InvestmentAssistant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    private int orderId;
    @Column(name = "USERID")
    private String userId;
    @Column(name = "VENDOR_ID")
    private int vendorId;
    @Column(name = "PRODUCT_ID")
    private long productId;
    @Column(name = "ORDER_STATUS")
    private String orderStatus;
    @Column(name = "TOTAL_PRICE")
    private long totalPrice;
    @Column(name = "TOTAL_QTY")
    private int totalQuantity;
    @Column(name = "PERUNITPRICE")
    private int perUnitPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(int perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }
}
