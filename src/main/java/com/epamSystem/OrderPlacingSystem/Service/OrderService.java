package com.epamSystem.OrderPlacingSystem.Service;

import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;

public interface OrderService {
    BillDetails calculateBill(Order orderDetails);
}
