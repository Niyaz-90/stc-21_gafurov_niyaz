package ru.inno.model;

import java.util.Date;

public class Order {
    private int orderId;

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    private int buyerId;
    private String address;
    private Date date;
    private int productId;
    private String paymentStatus;

    public Order(int orderId, int buyerId, String address, Date date, int productId, String paymentStatus) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.address = address;
        this.date = date;
        this.productId = productId;
        this.paymentStatus = paymentStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
