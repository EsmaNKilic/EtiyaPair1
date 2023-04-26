package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.repositories.abstracts.OrderDao;
import com.etiya.ecommercedemopair1.business.abstracts.OrderService;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private final OrderDao orderDao;

    @Override
    public void add(Order order) {
        Order orderToFindCustomerName = orderDao.findByCustomerName(order.getCustomer().getName());
        if(orderToFindCustomerName != null)
            return;
        orderDao.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderDao.getById(id);
    }
}
