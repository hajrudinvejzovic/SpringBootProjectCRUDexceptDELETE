package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Orders;
import com.SpringProject.SpringBootProject.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public List<Orders> allOrders(){
        return this.ordersRepository.findAll();
    }

}
