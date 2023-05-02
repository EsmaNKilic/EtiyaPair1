package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface OrderService {
    DataResult<List<ListOrderResponse>> getAll();
    DataResult<OrderDetailResponse> getById(int id);
    DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest);
    DataResult<UpdateOrderResponse> update(UpdateOrderRequest updateOrderRequest);
    Result delete(int id);

    DataResult<Slice<ListOrderResponse>>  getAllWithPagination(Pageable pageable);



}
