package com.etiya.ecommercedemopair1.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    private int id;
    private String name;
    private int categoryId;
    private String category;
}
