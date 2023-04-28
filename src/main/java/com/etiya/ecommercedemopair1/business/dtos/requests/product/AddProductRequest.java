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

    @NotBlank(message = "Name alanı boş bırakılamaz!") // alan boş bırakılamaz
    @NotNull(message = "Name alanı boş bırakılamaz!") // direkt alanı getirmez
    //@Length(min = 2, message = "Name alanı 2 karakterden kısa olamaz!")
    @Size(min = 2, message = "Name alanı 2 karakterden kısa olamaz!")
    private String name;

   @NotNull( message = "Bu alan boş kalamaz ")
    @Positive(message = "ürünün fiyatı 0 veya negatif olamaz")
    private Double unitPrice;


}
