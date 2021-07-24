package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;
import com.epamSystem.OrderPlacingSystem.vo.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {
    public BillDetails calculateBill(Order orderDetails) {
        double grandAmount = 0;
        BillDetails billDetails = new BillDetails();
        billDetails.setOrderId(orderDetails.getOrderId());
        List<Product> productList = new LinkedList<>();
        for(Product p: orderDetails.getProductDetails()) {
            Product currProductDetails = new Product();
            double amount = p.getPrice() * p.getQuantity();
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
