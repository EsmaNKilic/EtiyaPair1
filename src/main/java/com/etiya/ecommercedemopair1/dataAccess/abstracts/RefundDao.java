package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundDao extends JpaRepository<Refund,Integer> {
}
