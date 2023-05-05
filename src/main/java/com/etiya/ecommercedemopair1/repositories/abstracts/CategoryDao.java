package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    Category findByName(String name);

   boolean existsCategoryById(int id);



    // JPQL Jpa Query Language => Model ismi kullanır
    // SQL => tablo ismi kullanır

    @Query(value = "select  new com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse(c.id,c.name) from  Category c ")
    Slice<ListCategoryResponse> getAll(Pageable pageable);
}
