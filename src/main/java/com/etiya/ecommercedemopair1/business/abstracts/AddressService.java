package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();
    void add (Address address);
    Address getById (int id);
}
