package com.etiya.ecommercedemopair1.business.dtos.requests.category;

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
public class UpdateCategoryRequest {

    @Positive(message = "{PositiveValueIdMessage}")
    @NotNull(message = "{NotEmptyMessage}")
    private Integer id;

    @NotBlank(message = "{NotEmptyMessage}")
    @NotNull(message = "{NotEmptyMessage}")
    @Size(min = 2,message = "{MinCharacterMessage}")
    private String name;
}
