package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.ropositories.abstracts.AddressDao;
import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private final AddressDao addressDao;

    @Override
    public List<Address> getAll() {
        return addressDao.findAll();
    }

    @Override
    public void add(Address address) {
        Address addressToFindCountry = addressDao.findByCountry(address.getCountry().getName());
        if(addressToFindCountry != null)
            return;
        addressDao.save(address);
    }

    @Override
    public Address getById(int id) {
        return addressDao.getById(id);
    }
}
