package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.core.results.DataResult;
import com.etiya.ecommercedemopair1.core.results.Result;
import com.etiya.ecommercedemopair1.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<ListProductResponse>> getAll();
    DataResult<ProductDetailResponse> getById(int id);
    DataResult<AddProductResponse> add(AddProductRequest addProductRequest);

    //Result delete();
}
