package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Items_Per_Order;
import com.SpringProject.SpringBootProject.repository.Items_Per_OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items-per-order")
public class Items_Per_OrderController {
    @Autowired
    private Items_Per_OrderRepository items_per_orderRepository;
    @GetMapping
    public List<Items_Per_Order> allItemsPerOrder(){
        return this.items_per_orderRepository.findAll();
    }
}
