package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderDao extends JpaRepository<ProductOrder,Integer> {
}
