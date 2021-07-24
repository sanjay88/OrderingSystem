package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.Product;

public class OrangeOffer implements OfferService {
    @Override
    public double calculateAmount(Product p) {
        int pQuantity = p.getQuantity();
        double pPrice = p.getPrice();
        int quantityThreeOnPriceOfTwo = pQuantity/3;
        return ((quantityThreeOnPriceOfTwo*2*pPrice)+((pQuantity%3)*pPrice));
    }
}
