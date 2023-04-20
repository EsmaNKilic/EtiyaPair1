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
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private boolean status;

    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrders;

    @ManyToOne()
    @JoinColumn(name="shipping_id")
    private Shipping shipping;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;
}
