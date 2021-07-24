package com.epamSystem.OrderPlacingSystem.controller;

import com.epamSystem.OrderPlacingSystem.Service.OrderService;
import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/generateBill", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BillDetails generateBill(@RequestBody Order orderDetails) {
        return orderService.calculateBill(orderDetails);
    }
}
