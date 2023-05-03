package com.etiya.ecommercedemopair1.business.dtos.responses.product;

import com.etiya.ecommercedemopair1.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
    private int id;
    private String name;
    private Double unitPrice;
}
