package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class OfferStrategy {
    @Autowired
    private OfferService offerService;

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    public double calculateProductAmount(Product p) {
        return offerService.calculateAmount(p);
    }

}
