package com.etiya.ecommercedemopair1.business.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @OneToMany(mappedBy = "product") //solda yazan yer bulunduğun class yani şu an product = one
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product")
    private List<ProductOrder> productOrders;

    @ManyToOne()
    @JoinColumn(name="shopping_carts_id")
    private ShoppingCart shoppingCart;

    @ManyToOne()
    @JoinColumn(name="discounts_id")
    private Discount discount;

}
