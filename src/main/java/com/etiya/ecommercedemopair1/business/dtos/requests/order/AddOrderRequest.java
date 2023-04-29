package com.etiya.ecommercedemopair1.business.dtos.requests.order;

import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    @Size(max = 300, message = "açıklama 300 karakterden uzun olamaz")
    private String description;

    @NotNull(message = "Name alanı boş bırakılamaz!") // direkt alanı getirmez
    private Boolean status;

}
