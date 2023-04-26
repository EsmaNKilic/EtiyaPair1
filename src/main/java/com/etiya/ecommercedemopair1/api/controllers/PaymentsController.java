package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair1.entities.concretes.Payment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentsController {

    private final PaymentService paymentService;


    @PostMapping("")
    public void add(Payment payment) {
        paymentService.add(payment);
    }

    @GetMapping("")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public Payment getById(int id) {
        return paymentService.getById(id);
    }
}
