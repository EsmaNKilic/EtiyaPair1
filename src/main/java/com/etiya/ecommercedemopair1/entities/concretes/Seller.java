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
@Table(name="sellers")
public class Seller {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="boutique_name")
    private String boutiqueName;

    @Column(name="tax_no")
    private double taxNo;

    @OneToMany(mappedBy = "seller")
    private List<Refund> refunds;

    @ManyToOne()
    @JoinColumn(name="account_id")
    private Account account;
}
