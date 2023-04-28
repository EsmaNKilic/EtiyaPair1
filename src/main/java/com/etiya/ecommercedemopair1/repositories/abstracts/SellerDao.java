package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellerDao extends JpaRepository<Seller,Integer> {
    @Query("from Seller where boutiqueName= 'ENK'")
    List<Seller> getBySellerBoutiqueName();
}
