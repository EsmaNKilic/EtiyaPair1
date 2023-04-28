package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.Order;

import java.util.List;

public interface OrderService {
    void add(Order order);
    List<Order> getAll();
    Order getById(int id);

}
