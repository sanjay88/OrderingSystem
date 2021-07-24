package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.Product;

public interface OfferService {
    double calculateAmount(Product p);
}
