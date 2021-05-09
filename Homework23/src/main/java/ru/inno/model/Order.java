package ru.inno.model;

import java.util.Date;

public class Order {
    private int orderId;
    public static int orderIdCounter = 1;
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

    public static int addNewOrder() {
        return orderIdCounter++;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", buyerId=" + buyerId +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", productId=" + productId +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }

}
