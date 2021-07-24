package com.epamSystem.OrderPlacingSystem.vo;

import java.util.List;

public class BillDetails {
    private String orderId;
    private List<Product> productDetails;

    public BillDetails(String orderId, List<Product> productDetails, double grandTotal) {
        this.orderId = orderId;
        this.productDetails = productDetails;
        this.grandTotal = grandTotal;
    }

    public BillDetails() {}

    private double grandTotal;

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

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
