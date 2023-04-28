package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictDao extends JpaRepository<District,Integer> {

    @Query("FROM District where name like '%=:word'")
    List<District> getByDistrictStartWith(String word);
}