package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor

public class ProductsController {
    private ProductService productService;

    @GetMapping("")
    public DataResult<List<ListProductResponse>> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<ProductDetailResponse> getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public DataResult<AddProductResponse> add(@Valid @RequestBody AddProductRequest addProductRequest){
        return productService.add(addProductRequest);
    }

    @PutMapping()
    public DataResult<UpdateProductResponse> update(@Valid @RequestBody UpdateProductRequest updateProductRequest){
        return  productService.update(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.productService.delete(id);
    }


    @GetMapping("/getWithPagination")
    public DataResult<Slice<ListProductResponse>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return productService.getAllWithPagination(pageable);
    }
}
