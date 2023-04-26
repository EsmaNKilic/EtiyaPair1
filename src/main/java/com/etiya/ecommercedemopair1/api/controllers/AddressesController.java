package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {
    private AddressService addressService;

    @GetMapping("")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping("")
    public void Add(Address address){
        addressService.add(address);
    }

    @GetMapping("/{id}")
    public Address getById(int id) {
        return addressService.getById(id);
    }
}
