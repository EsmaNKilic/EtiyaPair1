package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.requests.product.UpdateProductRequest;
import com.etiya.ecommercedemopair1.core.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair1.core.internationalization.MessageManager;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperManager;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryDao;
import com.etiya.ecommercedemopair1.repositories.abstracts.ProductDao;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@AllArgsConstructor
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
    }

    @Test
    void getById() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAllWithPagination() {
    }

    @Test
    void categoryWithIdShouldExists(){
        when(categoryService.categoryWithIdShouldExists(any())).thenReturn(null);
        UpdateProductRequest  updateProductRequest = new UpdateProductRequest(2,"efe",20.0);
        assertThrows(BusinessException.class,()->{
            productManager.update(updateProductRequest);
        });
    }
}