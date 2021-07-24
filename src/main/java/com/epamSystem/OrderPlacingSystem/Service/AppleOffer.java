package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.Product;

public class AppleOffer implements OfferService {
    @Override
    public double calculateAmount(Product p) {
        int pQuantity = p.getQuantity();
        double pPrice = p.getPrice();
        int quantityOnPriceApplicable = pQuantity/2 + pQuantity%2;
        return quantityOnPriceApplicable * pPrice;
    }
}
