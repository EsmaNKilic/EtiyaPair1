package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.IndivicualCustomerService;
import com.etiya.ecommercedemopair1.business.dtos.requests.IndivicualCustomer.AddIndivicualCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.AddIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.IndivicualCustomer.ListIndivicualCustomerResponse;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import com.etiya.ecommercedemopair1.entities.concretes.IndivicualCustomer;
import com.etiya.ecommercedemopair1.repositories.abstracts.CustomerDao;
import com.etiya.ecommercedemopair1.repositories.abstracts.IndivicualCustomerDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndivicualCustomerManager  implements IndivicualCustomerService {

    private final IndivicualCustomerDao indivicualCustomerDao;
    private final ModelMapperService modelMapperService;
    private final CustomerDao customerDao;

    @Override
    public DataResult<List<ListIndivicualCustomerResponse>> getAll() {
        return  new SuccessDataResult<>(indivicualCustomerDao.getAll());
    }

    @Override
    public DataResult<AddIndivicualCustomerResponse> Add(AddIndivicualCustomerRequest addIndivicualCustomerRequest) {
        Customer customer = modelMapperService.forRequest().map(addIndivicualCustomerRequest,Customer.class);
        customerDao.save(customer);
        IndivicualCustomer indivicualCustomer = modelMapperService.forRequest().map(addIndivicualCustomerRequest,IndivicualCustomer.class);
        indivicualCustomerDao.save(indivicualCustomer);
        AddIndivicualCustomerResponse response  =  modelMapperService.forResponse().map(indivicualCustomer,AddIndivicualCustomerResponse.class);
        return  new SuccessDataResult<>(response);

    }
}
