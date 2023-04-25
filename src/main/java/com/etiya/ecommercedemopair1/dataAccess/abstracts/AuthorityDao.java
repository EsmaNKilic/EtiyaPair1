package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDao extends JpaRepository<Authority,Integer> {
    @Query("from Authority where roleName=:roleName")
    List<Authority> getAuthorityByRoleName(String roleName);
}
