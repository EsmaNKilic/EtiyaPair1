package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.ProductOrder.AddProductOrderRequest;
import com.etiya.ecommercedemopair1.core.utils.results.Result;

import java.util.List;

public interface ProductOrderService {
    Result addRange(int orderId, List<AddProductOrderRequest> addProductOrderRequest);
}
