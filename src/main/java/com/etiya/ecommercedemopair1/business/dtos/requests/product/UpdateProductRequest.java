package com.etiya.ecommercedemopair1.business.dtos.requests.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    @Positive(message = "{PositiveValueIdMessage}")
    @NotNull(message = "{NotEmptyMessage}")
    private Integer id;

    @NotBlank(message = "{NotEmptyMessage}!") // alan boş bırakılamaz
    @NotNull(message = "{NotEmptyMessage}") // direkt alanı getirmez
    @Size(min = 2, message = "{PositiveValueIdMessage}")
    private String name;

    @NotNull( message = "{NotEmptyMessage} ")
    @Positive(message = "{PositiveValueIdMessage}")
    private Double unitPrice;
}
