package com.etiya.ecommercedemopair1.dataAccess.contretes;

import com.etiya.ecommercedemopair1.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer,Integer> {
}
