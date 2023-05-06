package com.etiya.ecommercedemopair1.business.dtos.requests.ProductOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductOrderRequest {
    private int productId;
    //private int quantity;
}
