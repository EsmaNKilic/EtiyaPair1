package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {
    DataResult<List<ListProductResponse>> getAll();
    DataResult<ProductDetailResponse> getById(int id);
    DataResult<AddProductResponse> add(AddProductRequest addProductRequest);
    DataResult<UpdateProductResponse> update (UpdateProductRequest updateProductRequest);
    Result delete(int id);


    DataResult<Slice<ListProductResponse>> getAllWithPagination(Pageable pageable);
}
