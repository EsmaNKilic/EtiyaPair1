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

    @Positive(message = "0 veya negatif bir değere sahip id olamaz")
    @NotNull(message = "bu alan boş Bırakılamaz")
    private Integer id;

    @NotBlank(message = "Name alanı boş bırakılamaz!") // alan boş bırakılamaz
    @NotNull(message = "Name alanı zorunludur.!") // direkt alanı getirmez
    @Size(min = 2, message = "Name alanı 2 karakterden kısa olamaz!")
    private String name;

    @NotNull( message = "Bu alan boş kalamaz ")
    @Positive(message = "ürünün fiyatı 0 veya negatif olamaz")
    private Double unitPrice;
}
