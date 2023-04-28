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
@Table(name="refunds")
public class Refund {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="status")
    private boolean status;

    @Column(name="refund_no")
    private String refundNo;

    @Column(name="date")
    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name="seller_id")
    private Seller seller;

}
