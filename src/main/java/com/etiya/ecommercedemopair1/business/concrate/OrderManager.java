package com.etiya.ecommercedemopair1.business.concrate;


import com.etiya.ecommercedemopair1.business.abstracts.ProductOrderService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.ProductOrder;
import com.etiya.ecommercedemopair1.repositories.abstracts.OrderDao;

import com.etiya.ecommercedemopair1.business.abstracts.OrderService;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderDao orderDao;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;
    private final ProductOrderService productOrderService;


    @Override
    public DataResult<List<ListOrderResponse>> getAll() {

        List<Order> orders = this.orderDao.findAll();

        List<ListOrderResponse> response = orders.stream()
                .map(order -> this.modelMapperService.forResponse()
                        .map(order, ListOrderResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListOrderResponse>>(response, messageService.getMessage(Messages.Order.ListedOrder));
    }

    @Override
    public DataResult<OrderDetailResponse> getById(int id) {
        Order order = this.orderDao.findById(id).get();

        OrderDetailResponse response = this.modelMapperService.forResponse().map(order, OrderDetailResponse.class);

        return new SuccessDataResult<OrderDetailResponse>(response, messageService.getMessageWithParams(Messages.Order.GetOrderById, id));

    }

    @Override
    public DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest) {

        Order order = new Order();

        this.orderDao.save(order);

        productOrderService.addRange(order.getId(), addOrderRequest.getAddProductOrderRequests());


        AddOrderResponse response = this.modelMapperService.forResponse().map(order, AddOrderResponse.class);

        return new SuccessDataResult<AddOrderResponse>(response, messageService.getMessage(Messages.Order.OrderAdded));
    }

    @Override
    public DataResult<UpdateOrderResponse> update(UpdateOrderRequest updateOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);

        this.orderDao.save(order);

        UpdateOrderResponse response = this.modelMapperService.forResponse().map(order, UpdateOrderResponse.class);

        return new SuccessDataResult<UpdateOrderResponse>(response, messageService.getMessageWithParams(Messages.Order.UpdatedOrder, updateOrderRequest.getId()));
    }

    @Override
    public Result delete(int id) {

        this.orderDao.deleteById(id);

        return new SuccessResult(messageService.getMessage(Messages.Order.DeletedOrder));
    }

    @Override
    public DataResult<Slice<ListOrderResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(orderDao.getAll(pageable));
    }
}
