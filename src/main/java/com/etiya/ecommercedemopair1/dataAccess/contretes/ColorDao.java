package com.etiya.ecommercedemopair1.dataAccess.contretes;

import com.etiya.ecommercedemopair1.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color,Integer> {
}
