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

    @Positive(message = "0 veya negatif bir değere sahip id olamaz")
    @NotNull(message = "bu alan boş Bırakılamaz")
    private Integer id;

    @Size(max = 300, message = "açıklama 300 karakterden uzun olamaz")
    private String description;

    @NotNull(message = "Name alanı boş bırakılamaz!") // direkt alanı getirmez
    private Boolean status;
}
