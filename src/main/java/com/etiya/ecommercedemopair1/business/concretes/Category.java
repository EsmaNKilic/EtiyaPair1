package com.etiya.ecommercedemopair1.business.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Annotations
@Entity
@AllArgsConstructor // tüm propertyler ile doldurulmuş bir constructor oluşturur
@NoArgsConstructor // 0 parametreli bir constructor oluşturur
@Getter
@Setter
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategories;

}
