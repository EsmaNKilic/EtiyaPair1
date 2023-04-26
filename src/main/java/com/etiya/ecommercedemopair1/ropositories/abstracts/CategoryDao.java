package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    Category findByName(String name);

    @Query("from Category where id=:id")
    Category getCategoryById(int id);

}