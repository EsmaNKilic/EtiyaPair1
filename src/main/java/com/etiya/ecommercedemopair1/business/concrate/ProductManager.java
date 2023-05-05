package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair1.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair1.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.*;
import com.etiya.ecommercedemopair1.repositories.abstracts.ProductDao;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductManager implements ProductService {
    private final ProductDao productDao;
    private final CategoryService categoryService;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;

    @Override
    public DataResult<List<ListProductResponse>> getAll() {

        List<Product> products = this.productDao.findAll();

        List<ListProductResponse> response = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, ListProductResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListProductResponse>>(response, messageService.getMessage(Messages.Product.ListedProduct));
    }

    @Override
    public DataResult<ProductDetailResponse> getById(int id) {
checkIfProductIdExists(id);
        Product product = this.productDao.findById(id).get();

        ProductDetailResponse response = this.modelMapperService.forResponse().map(product, ProductDetailResponse.class);

        return new SuccessDataResult<ProductDetailResponse>(response, messageService.getMessageWithParams(Messages.Product.GetProductById, id));
    }

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {

        Product product = this.modelMapperService.forRequest().map(addProductRequest, Product.class);

        categoryWithIdShouldExists(addProductRequest.getCategoryId());

        this.productDao.save(product);

        AddProductResponse response = this.modelMapperService.forResponse().map(product, AddProductResponse.class);

        return new SuccessDataResult<AddProductResponse>(response, messageService.getMessage(Messages.Product.ProductAdded));
    }

    @Override
    public DataResult<UpdateProductResponse> update(UpdateProductRequest updateProductRequest) {

        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);

        this.productDao.save(product);

        UpdateProductResponse response = this.modelMapperService.forResponse().map(product, UpdateProductResponse.class);

        return new SuccessDataResult<UpdateProductResponse>(response, messageService.getMessageWithParams(Messages.Product.UpdatedProduct, updateProductRequest.getId()));
    }

    @Override
    public Result delete(int id)   {
checkIfProductIdExists(id);
        this.productDao.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Product.DeletedProduct));
    }

    @Override
    public DataResult<Slice<ListProductResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(productDao.getAll(pageable));
    }

    //CONTROLS
    private Result categoryWithIdShouldExists(int categoryId) {
        boolean isCategoryExists = productDao.existsById(categoryId);
        if (isCategoryExists)
            return new SuccessResult();
        return new ErrorResult();
    }

    public void checkIfProductIdExists(int id) {
        if (!productDao.existsById(id)) {
            throw new NotFoundException(messageService.getMessageWithParams(Messages.Product.NoExistsProductById,id));
        }

    }
}