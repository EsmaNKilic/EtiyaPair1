package com.etiya.ecommercedemopair1.business.dtos.requests.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

    @Positive(message = "{PositiveValueIdMessage}")
    @NotNull(message = "{NotEmptyMessage}")
    private Integer id;

    @Size(max = 300, message = "{MaxCharacterMessage}")
    private String description;

    @NotNull(message = "{NotEmptyMessage}") // direkt alanı getirmez
    private Boolean status;
}
