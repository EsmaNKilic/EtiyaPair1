package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("/getWithPagination")
    public DataResult<Slice<ListCategoryResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page-1,pageSize);
        return categoryService.getAllWithPagination(pageable);
    }

    @GetMapping("")
    // Business katmanı ile ilişki kurar.
    public DataResult<List<ListCategoryResponse>> getAll() {
        return categoryService.getAll();
    }

     @GetMapping("/{id}")
    public DataResult<CategoryDetailResponse> GetById(@PathVariable int id) {
        return categoryService.GetById(id);
    }

    @PostMapping("")
    public DataResult<AddCategoryResponse> add(@Valid @RequestBody AddCategoryRequest addCategoryRequest) throws Exception{
        return categoryService.add(addCategoryRequest);
    }

    @PutMapping()
    public DataResult<UpdateCategoryResponse> update(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest){
        return  categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.categoryService.delete(id);
    }


}
