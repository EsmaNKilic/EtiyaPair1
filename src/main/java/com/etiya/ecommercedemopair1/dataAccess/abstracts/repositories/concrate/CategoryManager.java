package com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.concrate;

import com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.dataAccess.abstracts.CategoryDao;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    
    private final CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
       return categoryDao.findAll();
    }

    @Override
    public void Add(Category category) {
        Category categoryToFind = categoryDao.findByName(category.getName());
        if(categoryToFind != null)
            return;
        categoryDao.save(category);
    }

    @Override
    public Category GetById(int id) {
        return categoryDao.getById(id);
    }
}
