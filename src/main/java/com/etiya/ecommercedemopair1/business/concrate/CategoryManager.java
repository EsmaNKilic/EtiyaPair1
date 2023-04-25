package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.dataAccess.abstracts.CategoryDao;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
      var result= categoryDao.FindByName(category.getName());

      if (result!=null){
          return;
      }

        categoryDao.save(category);
    }
}
