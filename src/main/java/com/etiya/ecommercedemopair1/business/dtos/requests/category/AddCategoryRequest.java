package com.etiya.ecommercedemopair1.business.dtos.requests.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// UpdateProductRequest
// DeleteOrderRequest
// DeleteOrderResponse
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
    @NotBlank(message ="{NotEmptyMessage}")
    @NotNull(message = "{NotEmptyMessage}")
    @Size(min = 2,message = "{MinCharacterMessage}")
    private String name;
}
