package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {

    Order findByCustomerName (String name);

    @Query("from Order where status=:status")
    List<Order> getOrderByStatus (boolean status);

    @Query("from Order where customer=:id")
    Order getOrderByCustomerId (int id);
}
