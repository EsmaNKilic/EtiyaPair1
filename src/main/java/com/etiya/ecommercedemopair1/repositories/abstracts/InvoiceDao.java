package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.business.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {

    @Query("FROM  Invoice where date>: date")
    List<Invoice> getByInvoiceDate(Date date);
}
