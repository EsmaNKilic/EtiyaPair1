package com.etiya.ecommercedemopair1.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="indivicual_customers")
public class IndivicualCustomer {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="identity_no")
    private String identityNo;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Customer customer;
}
