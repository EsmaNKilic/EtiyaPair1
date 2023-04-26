package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    void Add (Category  category);
    Category GetById (int id);
}
