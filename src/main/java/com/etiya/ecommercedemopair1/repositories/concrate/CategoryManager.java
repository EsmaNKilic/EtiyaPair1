package com.etiya.ecommercedemopair1.repositories.concrate;

import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.dataAccess.abstracts.CategoryDao;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor // Bu varken autowired yapmaya gerek kalmaz.
public class CategoryManager implements CategoryService {
    private final CategoryDao categoryDao;

    //@Autowired -> anatasyon, springin ilgili const. ilgili bağımlılıklarını springe iletir.
    // Otomatik olarak instance oluşturur, bağımlılıkları otomatik enjekte eder yani onun karşılığını git container'den al der.
    // IoC'de dependency injection yöntemi ile bir nesnenin referansını verir.
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
