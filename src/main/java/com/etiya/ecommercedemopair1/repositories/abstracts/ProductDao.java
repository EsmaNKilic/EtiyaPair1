package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
   Product findByName (String name);

   @Query(value = "Select new " +
         "com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse(p.id, p.name,p.unitPrice, c.name)" +
         " from Product p JOIN p.productCategories  join Category c order by p.name")
   List<ListProductResponse> getAll();

    @Query("from Product where name=:name")
    List<Product> getProductByName(String name);

}
