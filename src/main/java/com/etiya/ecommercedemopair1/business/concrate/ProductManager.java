package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.repositories.abstracts.ProductDao;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductManager implements ProductService {
  private ProductDao productDao;
  private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {

        Product product = this.modelMapperService.forRequest().map(addProductRequest, Product.class);

        this.productDao.save(product);

        AddProductResponse response = this.modelMapperService.forResponse().map(product, AddProductResponse.class);

        return new SuccessDataResult<AddProductResponse>(response);
    }

    @Override
    public DataResult<List<ListProductResponse>> getAll() {

        List<Product> products = this.productDao.findAll();

        List<ListProductResponse> response = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                .map(product, ListProductResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListProductResponse>>(response);
    }

    @Override
    public DataResult<ProductDetailResponse> getById(int id) {

        Product product = this.productDao.findById(id).get();

        ProductDetailResponse response = this.modelMapperService.forResponse().map(product, ProductDetailResponse.class);

        return new SuccessDataResult<ProductDetailResponse>(response);
    }
}
