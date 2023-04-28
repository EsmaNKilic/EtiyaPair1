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

   @Query(value="Select new com.etiya.ecommercedemopair1.business.dtos.responses.product" +
         ".ProductDetailResponse(p.id, p.name, c.id ,c.name)" +
         "from Product p Join p.productCategories join Category c Where p.id=:id ")
   ProductDetailResponse getById(int id);
}
