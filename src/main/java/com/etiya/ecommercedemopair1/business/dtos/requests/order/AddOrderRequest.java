package com.etiya.ecommercedemopair1.business.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private String description;
    private Boolean status;
}
