package com.epamSystem.OrderPlacingSystem.vo;

public class Product {
    private String itemName;
    private int quantity;
    private double price;
    private double amount;
    private boolean offer;

    public Product(String itemName, int quantity, double price, double amount) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public Product(){}

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
