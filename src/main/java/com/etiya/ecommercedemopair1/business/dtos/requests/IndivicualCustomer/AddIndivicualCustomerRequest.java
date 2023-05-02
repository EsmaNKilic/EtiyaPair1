package com.etiya.ecommercedemopair1.business.dtos.requests.IndivicualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddIndivicualCustomerRequest {

    private String name;
    private String surname;
    private Integer PhoneNumber;
    private String identityNo;
}
