package com.etiya.ecommercedemopair1.business.dtos.requests.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    private Integer id;
    private String name;
}
