package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeDao extends JpaRepository<ProductAttribute,Integer> {
}
