package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.IndivicualCustomerService;
import com.etiya.ecommercedemopair1.business.dtos.requests.IndivicualCustomer.AddIndivicualCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.AddIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.ListIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/indivicualcustomers")
@AllArgsConstructor
public class IndivicualCustomersController {


    private final IndivicualCustomerService indivicualCustomerService;

    @GetMapping("")
    public DataResult<List<ListIndivicualCustomerResponse>> getAll() {
    return indivicualCustomerService.getAll();
    }

        @PostMapping("")
    public DataResult<AddIndivicualCustomerResponse> Add(@RequestBody AddIndivicualCustomerRequest addIndivicualCustomerRequest) {
        return indivicualCustomerService.Add(addIndivicualCustomerRequest);
    }

}
