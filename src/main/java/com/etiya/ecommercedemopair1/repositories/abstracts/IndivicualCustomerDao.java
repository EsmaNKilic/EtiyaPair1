package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.IndivicualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndivicualCustomerDao extends JpaRepository<IndivicualCustomer,Integer> {
}
