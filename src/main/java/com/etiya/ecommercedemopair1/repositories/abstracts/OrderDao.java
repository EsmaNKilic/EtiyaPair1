package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {

    Order findByCustomerName (String name);

    @Query("from Order where status=:status")
    List<Order> getOrderByStatus (boolean status);

    @Query("from Order where customer=:id")
    Order getOrderByCustomerId (int id);

    @Query(value = "select  new  com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse(o.id,o.description,o.status) from  Order  o")
    Slice<ListOrderResponse> getAll(Pageable pageable);
}
