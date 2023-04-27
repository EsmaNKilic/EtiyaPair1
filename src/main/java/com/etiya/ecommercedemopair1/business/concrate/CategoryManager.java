package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;

import com.etiya.ecommercedemopair1.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.results.DataResult;
import com.etiya.ecommercedemopair1.core.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryDao;

import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor // Bu varken autowired yapmaya gerek kalmaz,constructorlamayı otomatikleştirir
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;

    //@Autowired -> anatasyon, springin ilgili const. ilgili bağımlılıklarını springe iletir. CategoryDao'yu enjekte edecek ortamı verecek.
    // Otomatik olarak instance oluşturur, bağımlılıkları otomatik enjekte eder yani onun karşılığını git container'den al der.
    // IoC'de dependency injection yöntemi ile bir nesnenin referansını verir.

    @Override
    public DataResult<List<ListCategoryResponse>> getAll() {

        List<Category> categories = this.categoryDao.findAll();

        List<ListCategoryResponse> response = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                .map(category, ListCategoryResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCategoryResponse>>(response);
    }

    /*@Override
    public DataResult<GetCategoryResponse> GetById(int id) {

        Category category = this.categoryDao.findById(id).get();

        GetCategoryResponse response = this.modelMapperService.forResponse().map(category, GetCategoryResponse.class);

        return new SuccessDataResult<GetCategoryResponse>(response);
    }*/

    @Override
    public DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest){

        Category category = this.modelMapperService.forRequest().map(addCategoryRequest, Category.class);

        this.categoryDao.save(category);

        AddCategoryResponse response = this.modelMapperService.forResponse().map(category, AddCategoryResponse.class);

        return new SuccessDataResult<AddCategoryResponse>(response);
    }
}
