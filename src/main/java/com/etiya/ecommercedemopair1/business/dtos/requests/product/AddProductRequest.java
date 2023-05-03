package com.etiya.ecommercedemopair1.business.dtos.requests.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {

    @NotBlank(message = "{NotEmptyMessage}") // alan boş bırakılamaz
    @NotNull(message = "{NotEmptyMessage}") // direkt alanı getirmez
    @Size(min = 2, message = "{MinCharacterMessage}")
    private String name;

    @NotNull( message = "{NotEmptyMessage}")
    @Positive(message = "{PositiveValueIdMessage]")
    private Double unitPrice;

    private int categoryId;
}
