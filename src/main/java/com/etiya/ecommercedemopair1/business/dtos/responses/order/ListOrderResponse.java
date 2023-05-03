package com.etiya.ecommercedemopair1.business.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderResponse {
    private Integer id;
    private String description;
    private Boolean status;

}
