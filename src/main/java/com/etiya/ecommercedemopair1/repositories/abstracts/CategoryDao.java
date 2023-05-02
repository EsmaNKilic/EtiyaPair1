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
    Category getById(int id);
    boolean existsCategoryById(int id);

    // JPQL Jpa Query Language => Model ismi kullanır
    // SQL => tablo ismi kullanır
    @Query("from Category where id=:id")
    Category getCategoryById(int id);

    @Query(value = "Select new " +
            "com.etiya.ecommercedemopair1.business.dtos.responses.category.ListCategoryResponse(c.id, c.name) " +
            "From Category c",
            nativeQuery = false)
    List<ListCategoryResponse> getAll();
    Slice<ListCategoryResponse> getAll(Pageable pageable);
}
