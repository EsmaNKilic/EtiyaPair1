package com.etiya.ecommercedemopair1.business.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryResponse {
    private int id;
    private String name;
}
