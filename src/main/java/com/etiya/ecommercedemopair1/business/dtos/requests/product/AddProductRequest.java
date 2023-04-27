package com.etiya.ecommercedemopair1.business.dtos.requests.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {

    @NotBlank(message = "Name alanı boş bırakılamaz!") // alan boş bırakılamaz
    @NotNull(message = "Name alanı boş bırakılamaz!") // direkt alanı getirmez
    //@Length(min = 2, message = "Name alanı 2 karakterden kısa olamaz!")
    @Size(min = 2, message = "Name alanı 2 karakterden kısa olamaz!")
    private String name;

    @Min(1)
    private double unitPrice;

    @NotBlank(message = "Name alanı boş bırakılamaz!")
    @NotNull(message = "Name alanı boş bırakılamaz!")
    private int categoryId;
}