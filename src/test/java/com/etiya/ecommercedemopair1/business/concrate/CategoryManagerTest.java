package com.etiya.ecommercedemopair1.business.concrate;


import com.etiya.ecommercedemopair1.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair1.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair1.core.internationalization.MessageManager;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperManager;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class CategoryManagerTest {
    CategoryDao categoryDao;
    ModelMapperService modelMapperService;
    MessageService messageService;
    CategoryManager categoryManager;

    @BeforeEach
    void setUp() {
        // Her test öncesi çalıştırılacak alan
        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageService  =  new MessageManager(getBundleMessageSource());
        categoryDao = mock(CategoryDao.class);
        categoryManager = new CategoryManager(categoryDao, modelMapperService,messageService);
    }

    public ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Test
    void updateWithNonExistingIdShouldThrowException() {
        when(categoryDao.findById(any())).thenReturn(Optional.ofNullable(null));
        UpdateCategoryRequest request = new UpdateCategoryRequest(1, "deneme");

        assertThrows(NotFoundException.class, () -> {
            categoryManager.update(request);
        });
    }
    @Test
    void update(){
        when(categoryDao.existsById(any())).thenReturn(true);

        UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest(1, "Giyim");
        DataResult<UpdateCategoryResponse> actualResponse = categoryManager.update(updateCategoryRequest);

        SuccessDataResult<UpdateCategoryResponse> expectedResponse =
                new SuccessDataResult<>(new UpdateCategoryResponse(1, "Giyim"));

        assert actualResponse.getData().equals(expectedResponse.getData());
    }

}