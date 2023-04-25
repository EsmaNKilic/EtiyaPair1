package com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    void add(Product product);

    Product getById(int id);
}