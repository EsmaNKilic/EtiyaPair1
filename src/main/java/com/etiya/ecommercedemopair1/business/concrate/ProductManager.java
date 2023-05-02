package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair1.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessResult;
import com.etiya.ecommercedemopair1.repositories.abstracts.ProductDao;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductManager implements ProductService {
  private ProductDao productDao;
  private final CategoryService categoryService;
  private ModelMapperService modelMapperService;
  private MessageSource messageSource;

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

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {

        Product product = this.modelMapperService.forRequest().map(addProductRequest, Product.class);

        categoryWithIdShouldExists(addProductRequest.getCategoryId());

        this.productDao.save(product);

        AddProductResponse response = this.modelMapperService.forResponse().map(product, AddProductResponse.class);

        return new SuccessDataResult<AddProductResponse>(response, Messages.Product.ProductAdded);
    }

    @Override
    public DataResult<UpdateProductResponse> update(UpdateProductRequest updateProductRequest) {

        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);

        product.setId(updateProductRequest.getId());

        this.productDao.save(product);

        UpdateProductResponse response = this.modelMapperService.forResponse().map(product, UpdateProductResponse.class);

        return new SuccessDataResult<UpdateProductResponse>(response,messageSource.getMessage("productUpdated",null, LocaleContextHolder.getLocale()));
    }

    @Override
    public Result delete(int id) {

        this.productDao.deleteById(id);

        return new SuccessResult(messageSource.getMessage("productDeleted",null, LocaleContextHolder.getLocale()));
    }


    //CONTROLS
    private void categoryWithIdShouldExists(int categoryId){
        Result categoryExists = categoryService.categoryWithIdShouldExists(categoryId);
        if(!categoryExists.isSuccess()){
            throw new BusinessException(Messages.Category.CategoryDoesNotExistsWithGivenId);
        }
    }
}
