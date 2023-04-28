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
    @NotBlank(message = "Bu alan boş bırakılamaz")
    @NotNull(message = "Bu alan boş bırakılamaz")
    @Size(min = 2,message = "Bu alan 2 harften küçük olamaz")
    private String name;
}
