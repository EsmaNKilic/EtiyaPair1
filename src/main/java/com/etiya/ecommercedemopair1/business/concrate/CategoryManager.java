package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;

import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair1.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair1.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.*;
import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryDao;

import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor // Bu varken autowired yapmaya gerek kalmaz,constructorlamayı otomatikleştirir
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;
    private MessageService messageService;

    //@Autowired -> anatasyon, springin ilgili const. ilgili bağımlılıklarını springe iletir. CategoryDao'yu enjekte edecek ortamı verecek.
    // Otomatik olarak instance oluşturur, bağımlılıkları otomatik enjekte eder yani onun karşılığını git container'den al der.
    // IoC'de dependency injection yöntemi ile bir nesnenin referansını verir.

    @Override
    public DataResult<Slice<ListCategoryResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(categoryDao.getAll(pageable));
    }

    @Override
    public DataResult<List<ListCategoryResponse>> getAll() {

        List<Category> categories = this.categoryDao.findAll();

        List<ListCategoryResponse> response = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                .map(category, ListCategoryResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCategoryResponse>>(response);
    }

    @Override
    public DataResult<CategoryDetailResponse> GetById(int id) {

        Category category = this.categoryDao.findById(id).get();

        CategoryDetailResponse response = this.modelMapperService.forResponse().map(category, CategoryDetailResponse.class);

        return new SuccessDataResult<CategoryDetailResponse>(response);
    }

    @Override
    public DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest)throws Exception{

        checkIfCategoryWithSameNameExists(addCategoryRequest.getName());

        Category category = this.modelMapperService.forRequest().map(addCategoryRequest, Category.class);

        this.categoryDao.save(category);

        AddCategoryResponse response = this.modelMapperService.forResponse().map(category, AddCategoryResponse.class);

        return new SuccessDataResult<AddCategoryResponse>(response);
    }

    @Override
    public Result categoryWithIdShouldExists(int categoryId) {
        boolean isCategoryExists = categoryDao.existsCategoryById(categoryId);
        if(isCategoryExists)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest) {
        checkIfCategoryWithIdExists(updateCategoryRequest.getId());

        Category category = categoryDao.findById(updateCategoryRequest.getId())
                .orElseThrow(() -> new NotFoundException(messageService.getMessageWithParams(Messages.Category.CategoryDoesNotExistsWithGivenId, updateCategoryRequest.getId())));
        checkIfCategoryWithSameNameExists(updateCategoryRequest.getName());

        category.setId(updateCategoryRequest.getId());

        this.categoryDao.save(category);

        UpdateCategoryResponse response = this.modelMapperService.forResponse().map(category, UpdateCategoryResponse.class);

        return new SuccessDataResult<UpdateCategoryResponse>(response);
    }

    @Override
    public Result delete(int id) {

        this.categoryDao.deleteById(id);

        return new SuccessResult();
    }


    //CONTROLS
    private void checkIfCategoryWithIdExists(int categoryId){
        if(!categoryWithIdShouldExists(categoryId).isSuccess())
            throw new BusinessException(messageService.getMessage(Messages.Category.CategoryDoesNotExistsWithGivenId));
    }

    private void checkIfCategoryWithSameNameExists(String categoryName){
        Category categoryToFind = categoryDao.findByName(categoryName);
        if(categoryToFind != null)
            throw new BusinessException(messageService.getMessage(Messages.Category.CategoryExists));
    }

}
