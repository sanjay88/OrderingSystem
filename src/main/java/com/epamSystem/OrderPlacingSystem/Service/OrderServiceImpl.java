package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;
import com.epamSystem.OrderPlacingSystem.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CacheManager cacheManager;

    @CachePut(value = "billDetails", key = "#orderDetails.orderId")
    public BillDetails calculateBill(Order orderDetails) {
        //logger.debug(" calculateBill method enter ", OrderServiceImpl.class);
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
        //logger.debug(" calculateBill method exit ", OrderServiceImpl.class);
        return billDetails;
    }

    @Override
    public BillDetails findOrderDetailsByOrderId(String orderId) {
        BillDetails billDetails = null;
        if (cacheManager.getCache("billDetails") != null && cacheManager.getCache("billDetails").get(orderId) != null)
            billDetails = (BillDetails) cacheManager.getCache("billDetails").get(orderId).get();
        return billDetails;
    }

    @Override
    public List<BillDetails> findAllOrderDetails() {
        List<BillDetails> billDetailsList = null;
        if(cacheManager.getCache("billDetails") != null) {
            Map<Object, Object> map = (Map<Object, Object>) cacheManager.getCache("billDetails").getNativeCache();
            billDetailsList = new LinkedList<>();
            for(Map.Entry<Object, Object> entry : map.entrySet()) {
                billDetailsList.add((BillDetails) entry.getValue());
            }
        }
        return billDetailsList;
    }


}
