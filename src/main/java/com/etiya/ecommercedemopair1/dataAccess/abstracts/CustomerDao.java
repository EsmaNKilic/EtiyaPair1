package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

    @Query("from Customer where name=: name")
    List<Customer> getByCustomerName(String name);

    @Query("select cu.id,cu.name,cu.surname,ci.identityNo,co.companyName from Customer cu " +
            "left join IndivicualCustomer ci on cu.id=ci.customer.id " +
            "inner join CorporateCustomer co on co.customer.id=cu.id")
    List<Customer> getCustomerList();
}
