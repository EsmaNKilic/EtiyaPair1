package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColorDao extends JpaRepository<Color,Integer> {
    @Query("from Color where id=:colorId")
    Color getColorById(int colorId);
}
