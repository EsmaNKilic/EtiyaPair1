package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.repositories.abstracts.OrderService;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @GetMapping("")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping("")
    public void Add(Order order) {
        orderService.add(order);
    }

    @GetMapping("/{id}")
    public Order getById(int id) {
        return orderService.getById(id);
    }
}
