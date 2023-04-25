package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DiscountDao extends JpaRepository<Discount,Integer> {

    @Query("FROM Discount where expireDate>: date")
    List<Discount> getDiscountByExpireDate(Date date);
}
