package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair1.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair1.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair1.core.internationalization.MessageManager;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperManager;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @AfterEach
    void tearDown() {
        // Her test sonrası çalıştırılacak alan
    }

    @Test
    void add() {
        // 3A Principle ↓
        // Arrange => Test yapılacak ortamı hazırlar, mock objelerin oluşturulması, bağımlılıkların yüklenmesi
        // Act(Action) => CategoryManager.add(); test edeceğin metodun işleme alınması
        // Assert(Beklenti) => Expected durum ile Real durum karşılaştırmasının yapıldığı nokta => categoryManager.add().throwsException() ? boolean
    }
/*
    @Test
    void getAll(){
        // mock
        List<ListCategoryResponse> expectedData = new ArrayList<>();
        expectedData.add(new ListCategoryResponse(1,"Giyim"));
        expectedData.add(new ListCategoryResponse(2, "Deneme"));
        Pageable pageable = PageRequest.of(0,0);
        when(categoryDao.getAll(pageable)).thenReturn(expectedData);


        DataResult<List<ListCategoryResponse>> actualResult = categoryManager.getAll();

        assert expectedData.size() == actualResult.getData().size();
    }

 */

    @Test
    void updateWithNonExistingIdShouldThrowException(){
        // findById
        // Mocklamada parametreler
        // herhangi bir parametre
        when(categoryDao.findById(any())).thenReturn(Optional.ofNullable(null));
        UpdateCategoryRequest request = new UpdateCategoryRequest(2,"Giyim");
        assertThrows(NotFoundException.class,()->{
            categoryManager.update(request);
        });
    }

    @Test
    void updateWithSameNameShouldThrowException(){
        when(categoryDao.findById(any())).thenReturn(Optional.of(new Category()));
        when(categoryDao.findByName(any())).thenReturn(new Category());
        UpdateCategoryRequest request = new UpdateCategoryRequest(2,"Deneme");
        assertThrows(BusinessException.class, () -> { categoryManager.update(request); });
    }

    @Test
    void update(){
        when(categoryDao.findById(any())).thenReturn(Optional.of(new Category()));
        when(categoryDao.findByName(any())).thenReturn(null);

        UpdateCategoryRequest request = new UpdateCategoryRequest(2,"Deneme");

        DataResult<UpdateCategoryResponse> actualResponse = categoryManager.update(request);
        SuccessDataResult<UpdateCategoryResponse> expectedResponse =
                new SuccessDataResult<>(new UpdateCategoryResponse(2,"Deneme"));
        assert actualResponse.equals(expectedResponse);
    }
}