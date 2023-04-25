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
@Table(name="product_attributes")
public class ProductAttribute {
    @Id
    @Column(name="id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Product product;

    @OneToMany(mappedBy = "productAttribute")
    private List<Color> colors;

    @OneToMany(mappedBy = "productAttribute")
    private List<Size> sizes;

}
