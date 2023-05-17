package com.SpringProject.SpringBootProject.controller;

import com.SpringProject.SpringBootProject.entity.Payments;
import com.SpringProject.SpringBootProject.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
