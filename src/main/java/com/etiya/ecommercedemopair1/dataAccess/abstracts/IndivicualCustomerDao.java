package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.IndivicualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndivicualCustomerDao extends JpaRepository<IndivicualCustomer,Integer> {
}
