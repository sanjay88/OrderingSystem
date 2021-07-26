package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;

import java.util.List;

public interface OrderService {
    BillDetails calculateBill(Order orderDetails);

    BillDetails findOrderDetailsByOrderId(String orderId);

    List<BillDetails> findAllOrderDetails();
}
