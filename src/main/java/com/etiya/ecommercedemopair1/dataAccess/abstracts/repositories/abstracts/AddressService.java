package com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();
    void add (Address address);
    Address getById (int id);
}
