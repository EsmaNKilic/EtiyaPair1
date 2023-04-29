package com.etiya.ecommercedemopair1.business.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryResponse {
    private int id;
    private String name;
}
