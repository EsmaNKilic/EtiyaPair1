package com.etiya.ecommercedemopair1.business.abstracts;
import com.etiya.ecommercedemopair1.entities.concretes.Payment;

import java.util.List;

public interface PaymentService {

    void add(Payment payment);
    List<Payment> getAll();
    Payment getById(int id);

}
