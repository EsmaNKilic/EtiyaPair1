package com.etiya.ecommercedemopair1.business.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private Integer id;
    private String description;
    private Boolean status;
}
