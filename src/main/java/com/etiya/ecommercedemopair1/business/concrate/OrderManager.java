package com.etiya.ecommercedemopair1.business.concrate;


import com.etiya.ecommercedemopair1.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessResult;
import com.etiya.ecommercedemopair1.repositories.abstracts.OrderDao;

import com.etiya.ecommercedemopair1.business.abstracts.OrderService;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderDao orderDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


    @Override
    public DataResult<List<ListOrderResponse>> getAll() {

        List<Order> orders = this.orderDao.findAll();

        List<ListOrderResponse> response = orders.stream()
                .map(order -> this.modelMapperService.forResponse()
                        .map(order, ListOrderResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListOrderResponse>>(response);
    }

    @Override
    public DataResult<OrderDetailResponse> getById(int id) {
        Order order = this.orderDao.findById(id).get();

        OrderDetailResponse response = this.modelMapperService.forResponse().map(order, OrderDetailResponse.class);

        return new SuccessDataResult<OrderDetailResponse>(response);
    }

    @Override
    public DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest) {

        Order order = this.modelMapperService.forRequest().map(addOrderRequest, Order.class);

        this.orderDao.save(order);

        AddOrderResponse response = this.modelMapperService.forResponse().map(order, AddOrderResponse.class);

        return new SuccessDataResult<AddOrderResponse>(response, messageSource.getMessage("orderAdded",null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UpdateOrderResponse> update(UpdateOrderRequest updateOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);

        order.setId(updateOrderRequest.getId());

        this.orderDao.save(order);

        UpdateOrderResponse response = this.modelMapperService.forResponse().map(order, UpdateOrderResponse.class);

        return new SuccessDataResult<UpdateOrderResponse>(response, messageSource.getMessage("orderUpdated",null, LocaleContextHolder.getLocale()));
    }

    @Override
    public Result delete(int id) {

        this.orderDao.deleteById(id);

        return new SuccessResult(messageSource.getMessage("orderDeleted",null, LocaleContextHolder.getLocale()));
    }
}
