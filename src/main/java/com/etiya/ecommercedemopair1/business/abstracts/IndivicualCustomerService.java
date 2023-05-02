package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.IndivicualCustomer.AddIndivicualCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.AddIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.ListIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;

import java.util.List;

public interface IndivicualCustomerService {
    DataResult<List<ListIndivicualCustomerResponse>> getAll();
    DataResult<AddIndivicualCustomerResponse> Add(AddIndivicualCustomerRequest addIndivicualCustomerRequest);
}
