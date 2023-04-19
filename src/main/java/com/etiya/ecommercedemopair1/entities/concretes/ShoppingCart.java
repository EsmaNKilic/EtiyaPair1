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
@Table(name="shopping_carts")
public class ShoppingCart {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="total_price")
    private double totalPrice;

    @Column(name="discount")
    private double discount;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Product> products;
}
