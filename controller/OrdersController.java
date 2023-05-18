package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Orders;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.OrdersRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;
    private OrdersController ;

    @GetMapping
    public List<Orders> allOrders(){
        return this.ordersRepository.findAll();
    }
    @GetMapping("/{id}")
    public Orders orderById(@PathVariable(value = "id") long orderId){
        return this.ordersRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order with this Id NOT FOUND" + orderId));
    }
    @PostMapping
    public Orders order(@RequestBody Orders order){
        return this.ordersRepository.save(order);
    }
    @PutMapping("/{id}")
    public Orders updateOrder(@RequestBody Orders order, @PathVariable(value = "id") long orderId){
        Orders existingUser = this.ordersRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order with this Id NOT FOUND" + orderId));
        existingUser.setUser(existingUser.getUser());
        existingUser.setOrder(existingUser.getOrder());
        existingUser.setPayment(existingUser.getPayment());
        existingUser.setTotal_price(existingUser.getTotal_price());
        existingUser.setTotal_quantity(existingUser.getTotal_quantity());
        return this.ordersRepository.save(existingUser);
    }

}
