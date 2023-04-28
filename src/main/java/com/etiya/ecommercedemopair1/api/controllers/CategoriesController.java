package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.core.results.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping("")
    // Business katmanı ile ilişki kurar.
    public DataResult<List<ListCategoryResponse>> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("")
    public DataResult<AddCategoryResponse> add(@Valid @RequestBody AddCategoryRequest addCategoryRequest) throws Exception{
        return categoryService.add(addCategoryRequest);
    }

    /*@GetMapping("/{id}")
    public DataResult<Category> GetById(@PathVariable int id) {
        return categoryService.GetById(id);
    }*/
}
