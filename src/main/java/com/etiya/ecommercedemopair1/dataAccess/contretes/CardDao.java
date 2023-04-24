package com.etiya.ecommercedemopair1.dataAccess.contretes;

import com.etiya.ecommercedemopair1.entities.concretes.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao extends JpaRepository<Card,Integer>{
}
