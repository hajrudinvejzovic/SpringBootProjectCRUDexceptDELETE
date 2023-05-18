package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Items_Per_Order;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.Items_Per_OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public Items_Per_Order itemsPerOrderById(@PathVariable(value = "id") long itemsPerOrderId){
        return this.items_per_orderRepository.findById(itemsPerOrderId)
                .orElseThrow(()-> new ResourceNotFoundException("Items Per Order with this Id NOT FOUND!" + itemsPerOrderId));
    }
    @PostMapping
    public Items_Per_Order itemsPerOrder(@RequestBody Items_Per_Order itemsPerOrder){
        return this.items_per_orderRepository.save(itemsPerOrder);
    }
    @PutMapping("/{id}")
    public Items_Per_Order updateItemsPerOrder(@RequestBody Items_Per_Order itemsPerOrder, @PathVariable(value = "id") long itemsPerOrderId){
        Items_Per_Order existingItemsPerOrder = this.items_per_orderRepository.findById(itemsPerOrderId)
                .orElseThrow(()-> new ResourceNotFoundException("Items Per Order with this Id NOT FOUND"  + itemsPerOrderId));
        existingItemsPerOrder.setOrder(existingItemsPerOrder.getOrder());
        existingItemsPerOrder.setBook(existingItemsPerOrder.getBook());
        existingItemsPerOrder.setQuantity(existingItemsPerOrder.getQuantity());
        return this.items_per_orderRepository.save(existingItemsPerOrder);

    }
}
