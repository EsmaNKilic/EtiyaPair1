package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.core.results.DataResult;

import java.util.List;

public interface CategoryService {
    DataResult<List<ListCategoryResponse>> getAll();
    //DataResult<GetCategoryResponse> GetById (int id);
    DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest) throws Exception;

    //Result delete();
}
