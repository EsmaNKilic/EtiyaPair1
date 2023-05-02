package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.ListIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.entities.concretes.IndivicualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndivicualCustomerDao extends JpaRepository<IndivicualCustomer,Integer> {

    @Query(value = "select new com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.ListIndivicualCustomerResponse(c.id,c.name,c.surname,c.phoneNumber,ic.identityNo) " +
            "from IndivicualCustomer ic join Customer c")
    List<ListIndivicualCustomerResponse> getAll();
}
