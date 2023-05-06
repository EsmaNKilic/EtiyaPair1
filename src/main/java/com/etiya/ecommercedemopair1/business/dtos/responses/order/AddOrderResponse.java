package com.etiya.ecommercedemopair1.business.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderResponse {
    private int id;
    private String description;
    private boolean status;
    private  int productId;
}
