package com.etiya.ecommercedemopair1.dataAccess.contretes;

import com.etiya.ecommercedemopair1.entities.concretes.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderDao extends JpaRepository<ProductOrder,Integer> {
}