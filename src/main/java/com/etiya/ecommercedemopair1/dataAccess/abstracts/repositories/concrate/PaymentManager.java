package com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.concrate;

import com.etiya.ecommercedemopair1.dataAccess.abstracts.PaymentDao;
import com.etiya.ecommercedemopair1.dataAccess.abstracts.repositories.abstracts.PaymentService;
import com.etiya.ecommercedemopair1.entities.concretes.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private final PaymentDao paymentDao;

    @Override
    public void add(Payment payment) {
        Payment paymentToFindMethodType = paymentDao.findByMethodType(payment.getMethodType());
        if(paymentToFindMethodType != null)
            return;
        paymentDao.save(payment);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.findAll();
    }

    @Override
    public Payment getById(int id) {
        return paymentDao.getById(id);
    }
}
