package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardDao extends JpaRepository<Card,Integer>{
    @Query("from Card where name=:cardName")
    List<Card> getCardByName(String cardName);
}
