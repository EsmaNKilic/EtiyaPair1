package com.etiya.ecommercedemopair1.business.dtos.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Integer id;
    private String name;
    private Double unitPrice;
}
