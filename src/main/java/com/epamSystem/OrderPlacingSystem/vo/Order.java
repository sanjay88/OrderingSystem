package com.epamSystem.OrderPlacingSystem.vo;

import java.util.List;

public class Order {
    private String orderId;
    private List<Product> productDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<Product> productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productDetails=" + productDetails +
                '}';
    }
}
