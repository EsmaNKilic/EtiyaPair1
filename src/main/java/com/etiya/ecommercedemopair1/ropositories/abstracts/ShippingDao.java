package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingDao extends JpaRepository<Shipping,Integer> {
    @Query("from Shipping where cargoType=:cargoType")
    List<Shipping> getShippingByCargoType (String cargoType);
}
