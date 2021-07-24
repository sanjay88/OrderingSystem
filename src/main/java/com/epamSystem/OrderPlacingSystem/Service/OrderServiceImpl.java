package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;
import com.epamSystem.OrderPlacingSystem.vo.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    public BillDetails calculateBill(Order orderDetails) {
        double grandAmount = 0;
        BillDetails billDetails = new BillDetails();
        billDetails.setOrderId(orderDetails.getOrderId());
        List<Product> productList = new LinkedList<>();
        for(Product p: orderDetails.getProductDetails()) {
            Product currProductDetails = new Product();
            double amount;
            if(p.isOffer()) {
                OfferStrategy offerStrategy = new OfferStrategy();
                if(p.getItemName().equals("Apple")) {
                    offerStrategy.setOfferService(new AppleOffer());
                } else {
                    offerStrategy.setOfferService(new OrangeOffer());
                }
                amount = offerStrategy.calculateProductAmount(p);
            } else {
                amount = p.getPrice() * p.getQuantity();
            }
            grandAmount += amount;
            currProductDetails.setItemName(p.getItemName());
            currProductDetails.setPrice(p.getPrice());
            currProductDetails.setQuantity(p.getQuantity());
            currProductDetails.setAmount(amount);
            productList.add(currProductDetails);
        }
        billDetails.setProductDetails(productList);
        billDetails.setGrandTotal(grandAmount);
        return billDetails;
    }
}
