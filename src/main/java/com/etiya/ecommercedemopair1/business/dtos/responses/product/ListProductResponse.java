package com.etiya.ecommercedemopair1.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductResponse {
    private Integer id;
    private String name;
    private Double unitPrice;
    private String categoryName;
}
