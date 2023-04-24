package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeDao extends JpaRepository<Size, Integer> {
}
