package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDao extends JpaRepository<Account,Integer> {
    @Query("from Account where name like '%=:word' ")
    List<Account> getAccountByNameEndWith(String word);

}
