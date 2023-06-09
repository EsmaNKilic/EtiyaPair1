package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercedemopair1.core.internationalization.MessageManager;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperManager;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import com.etiya.ecommercedemopair1.repositories.abstracts.ProductDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductManagerTest {

    private  ProductDao productDao;
    private  CategoryService categoryService;
    private ModelMapperService modelMapperService;
    private MessageService messageService;
   private ProductManager productManager;

    @BeforeEach
    void setUp() {
        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageService  =  new MessageManager(getBundleMessageSource());
        productDao = mock(ProductDao.class);
        productManager = new ProductManager(productDao,categoryService,modelMapperService,messageService);
    }

    public ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Test
    void getAll() {
        List<ListProductResponse> expectedData = new ArrayList<>();
        expectedData.add(new ListProductResponse(1,"Giyim",22.0,"AA"));
        expectedData.add(new ListProductResponse(2,"AA",22.0,"AA"));
        when(productDao.getAll()).thenReturn(expectedData);
    }

    @Test
    void update() {

        UpdateProductRequest updateProductRequest = new UpdateProductRequest(1,"da",20.0);
        DataResult<UpdateProductResponse> actualResponse = productManager.update(updateProductRequest);

        SuccessDataResult<UpdateProductResponse> expectedResponse =
                new SuccessDataResult<>(new UpdateProductResponse(1,"da",20.0));

        assert actualResponse.getData().equals(expectedResponse.getData());
    }

    @Test
    void getById(){
        when(productDao.findById(1)).thenReturn(Optional.of(new Product(1, "Elma", 22.0, 10, null, null, null, null)));
        DataResult<ProductDetailResponse> actualresult = new SuccessDataResult<>(new ProductDetailResponse(1, "Elma", 22.0, null));
        DataResult<ProductDetailResponse> expectedResult = productManager.getById(1);
        assert actualresult.getData().equals(expectedResult.getData());
    }
}