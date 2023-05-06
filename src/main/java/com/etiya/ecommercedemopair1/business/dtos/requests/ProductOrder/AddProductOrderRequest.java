package com.etiya.ecommercedemopair1.business.dtos.requests.ProductOrder;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductOrderRequest {
    @Positive(message = "{PositiveValueIdMessage}")
    @NotNull(message = "{NotEmptyMessage}")
    private int productId;

}
