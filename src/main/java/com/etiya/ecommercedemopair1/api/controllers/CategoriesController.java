package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("")
    // Business katmanı ile ilişki kurar.
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("")
    public void Add(Category category){
        categoryService.Add(category);
    }

    @GetMapping("/{id}")
    public Category GetById(int id) {
        return categoryService.GetById(id);
    }
}
