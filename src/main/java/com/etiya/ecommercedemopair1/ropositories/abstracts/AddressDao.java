package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository<Address,Integer> {

    Address findByCountry (String name);

    @Query("from Address where customer=:id")
    List<Address> getAddressByCustomerId(int id);

    @Query("select a.id,co.name,ci.name,di.name from Address a inner join Country co on co.id= a.country.id " +
            "inner join City  ci on ci.country.id= co.id inner join District di on di.city.id = ci.id")
    List<Address> GetAddressList();
}
