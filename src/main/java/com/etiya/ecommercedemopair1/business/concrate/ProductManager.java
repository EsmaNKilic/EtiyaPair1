package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.ropositories.abstracts.ProductDao;
import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

  private final ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {

        Product productToFind= productDao.findByName(product.getName());

        if (productToFind!=null) {
            return;
        }
         productDao.save(product);
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }
}
