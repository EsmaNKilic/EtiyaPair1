package com.etiya.ecommercedemopair1.repositories.abstracts;
import com.etiya.ecommercedemopair1.entities.concretes.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizeDao extends JpaRepository<Size, Integer> {
    @Query("from Size where width=:width and height=:height")
    List<Size> getSizeBySize(double width, double height);

    @Query("from Size where productAttribute=:id")
    Size getSizeByProductAttributeId (int id);
}
