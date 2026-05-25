package com.example.messagingapp.model;

import java.time.Instant;

public class Order {

    private String orderId;
    private String product;
    private int quantity;
    private Instant createdAt;

    public Order() {
        // JSON deserialization
    }

    public Order(String orderId, String product, int quantity, Instant createdAt) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
