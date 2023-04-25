package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.abstracts.ProductService;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping("")
    public void Add(Product product){
        productService.add(product);
    }

    @GetMapping("/{id}")
    public Product getById(int id) {
        return productService.getById(id);
    }
}
