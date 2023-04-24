package com.etiya.ecommercedemopair1.dataAccess.contretes;

import com.etiya.ecommercedemopair1.entities.concretes.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerDao extends JpaRepository<Seller,Integer> {
}
