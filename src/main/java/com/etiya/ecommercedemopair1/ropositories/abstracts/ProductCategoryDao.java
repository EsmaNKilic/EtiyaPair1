package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
}
