package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.responses.order.OrderDetailResponse;
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

  /*  @Query(value = "select  new com.etiya.ecommercedemopair1.business.dtos.responses.order" +
            ".OrderDetailResponse(o.id,o.description,o.status,c.name,c.surname,c.phoneNumber,p.name)" +
            " from Order o   join Customer c ON c.id = o.customer.id join ProductOrder pd ON pd.order.id = o.id " +
            "join Product p ON p.id = pd.product.id where o.id=:id")
    OrderDetailResponse getOrderDetails(Integer id);

   */
}
