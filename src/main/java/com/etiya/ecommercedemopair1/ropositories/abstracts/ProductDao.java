package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

   Product findByName (String name);

    @Query( "from  Product where unitPrice>: price")
    List<Product> getProductByUnitPrice(double price);

    @Query("from Product where name=:name")
    List<Product> getProductByName(String name);
}
