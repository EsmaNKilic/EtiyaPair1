package com.etiya.ecommercedemopair1.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="authorities")
public class Authority {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="role_name")
    private String roleName;

    @OneToMany(mappedBy = "authority")
    private List<Account> accounts;

}
