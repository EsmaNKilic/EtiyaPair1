package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart,Integer> {
    @Query("from ShoppingCart where discount<:total_price")
    List<ShoppingCart> getByShoppingCartDiscount(double discount);
}
