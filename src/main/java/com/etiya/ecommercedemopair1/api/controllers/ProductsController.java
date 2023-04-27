package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.core.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;

    @PostMapping("")
    public DataResult<AddProductResponse> add(@Valid AddProductRequest addProductRequest){
        return productService.add(addProductRequest);
    }

    @GetMapping("")
    public DataResult<List<ListProductResponse>> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<ProductDetailResponse> getById(@PathVariable int id){
        return productService.getById(id);
    }
}
