package com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListIndivicualCustomerResponse {
    private  Integer id;
    private String name;
    private String surname;
    private Integer PhoneNumber;
    private String identityNo;
}
