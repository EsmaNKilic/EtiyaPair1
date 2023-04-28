package com.etiya.ecommercedemopair1.business.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="height")
    private double height;

    @Column(name="width")
    private double width;

    @ManyToOne()
    @JoinColumn(name="product_attribute_id")
    private ProductAttribute productAttribute;
    
}
