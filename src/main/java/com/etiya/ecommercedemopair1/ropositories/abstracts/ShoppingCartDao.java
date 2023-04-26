package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart,Integer> {
    @Query("from ShoppingCart where discount<:discount")
    List<ShoppingCart> getByShoppingCartDiscount(double discount);
}
