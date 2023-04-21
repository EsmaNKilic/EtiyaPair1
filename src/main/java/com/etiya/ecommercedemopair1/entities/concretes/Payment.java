package com.etiya.ecommercedemopair1.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="method_type")
    private String mothod_type;

    @Column(name="installment")
    private int installment;

    @ManyToOne()
    @JoinColumn(name="card_id")
    private Card card;
}
