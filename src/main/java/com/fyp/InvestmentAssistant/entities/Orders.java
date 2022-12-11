package com.fyp.InvestmentAssistant.entities;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    private int orderId;
    @Column(name = "USERID")
    private int userId;
    @Column(name = "VENDOR_ID")
    private int vendorId;
    @Column(name = "PRODUCT_ID")
    private int productId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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
