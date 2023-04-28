package com.etiya.ecommercedemopair1.business.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="invoices")
public class Invoice {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="total_price")
    private double totalPrice;

    @Column(name="date")
    private Date date;

    @Column(name="tax")
    private double tax;

    @Column(name="quantity")
    private int quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Order order;
}
