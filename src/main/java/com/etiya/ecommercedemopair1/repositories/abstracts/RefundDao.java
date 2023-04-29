package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RefundDao extends JpaRepository<Refund,Integer> {
    @Query("from Refund where seller=:id")
    Refund getRefundBySellerId (int id);
}
