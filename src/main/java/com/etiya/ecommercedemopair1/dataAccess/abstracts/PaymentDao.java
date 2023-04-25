package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Card;
import com.etiya.ecommercedemopair1.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

    @Query("from Payment where method_type=:methodType")
    List<Payment> getByPaymentForMethodtype(String methodType);

    @Query("select p.id,c.name from Payment p inner join Card c on c.id = p.card.id")
    List<Payment> getPaymentByCardName();
}
