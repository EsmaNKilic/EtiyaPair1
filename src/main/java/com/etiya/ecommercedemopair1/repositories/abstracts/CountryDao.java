package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryDao extends JpaRepository<Country,Integer> {
    @Query("FROM Country where name like '%=:word'")
    List<Country> getByCountryStartWith(String word);
}
