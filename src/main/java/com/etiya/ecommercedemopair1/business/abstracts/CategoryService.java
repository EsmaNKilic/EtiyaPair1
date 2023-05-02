package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CategoryService {
    DataResult<Slice<ListCategoryResponse>> getAllWithPagination(Pageable pageable);
    DataResult<List<ListCategoryResponse>> getAll();
    DataResult<CategoryDetailResponse> GetById (int id);
    DataResult<AddCategoryResponse> add(AddCategoryRequest addCategoryRequest) throws Exception;
    DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest);
    Result delete(int id);
    Result categoryWithIdShouldExists(int categoryId);
}
