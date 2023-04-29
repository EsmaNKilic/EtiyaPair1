package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

    Payment findByMethodType(String Type);
    @Query("from Payment where methodType=:methodType")
    List<Payment> getByPaymentForMethodtype(String methodType);

    @Query("select p.id,c.name from Payment p inner join Card c on c.id = p.card.id")
    List<Payment> getPaymentByCardName();
}
