package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Payments;
import com.SpringProject.SpringBootProject.exception.ResourceNotFoundException;
import com.SpringProject.SpringBootProject.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentsController {
    @Autowired
    private PaymentsRepository paymentsRepository;

    @GetMapping
    public List<Payments> allPayments(){
        return this.paymentsRepository.findAll();
    }


    @GetMapping("/{id}")
    public Payments paymentById(@PathVariable(value = "id") long paymentId){
        return this.paymentsRepository.findById(paymentId)
                .orElseThrow(()-> new ResourceNotFoundException("Payment with this Id NOT FOUND!" + paymentId));
    }
    @PostMapping
    public Payments payment(@RequestBody Payments payment){
        return this.paymentsRepository.save(payment);
    }

    @PutMapping("/{id}")
    public Payments updatePayment(@RequestBody Payments payment, @PathVariable(value = "id") long paymentId){
        Payments existingPayment = this.paymentsRepository.findById(paymentId)
                .orElseThrow(()-> new ResourceNotFoundException("Payment with this Id NOT FOUND" + paymentId));
        existingPayment.setPayment_date(existingPayment.getPayment_date());
        existingPayment.setAmount(existingPayment.getAmount());
        existingPayment.setOrder(existingPayment.getOrder());
        existingPayment.setUser(existingPayment.getUser());
        existingPayment.setUsers_id(existingPayment.getUsers_id());
        return this.paymentsRepository.save(existingPayment);
    }
}
