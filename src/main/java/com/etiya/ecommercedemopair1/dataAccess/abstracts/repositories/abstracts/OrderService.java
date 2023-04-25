package com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Order;

import java.util.List;

public interface OrderService {

    void add(Order order);
    List<Order> getAll();
    Order getById(int id);

}
