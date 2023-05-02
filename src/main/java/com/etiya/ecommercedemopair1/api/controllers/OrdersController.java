package com.etiya.ecommercedemopair1.api.controllers;


import com.etiya.ecommercedemopair1.business.abstracts.OrderService;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {
    private OrderService orderService;

    @GetMapping("")
    public DataResult<List<ListOrderResponse>> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<OrderDetailResponse> GetById(@PathVariable int id) {
        return this.orderService.getById(id);
    }

    @PostMapping("")
    public DataResult<AddOrderResponse> add(@Valid @RequestBody AddOrderRequest addOrderRequest) throws Exception{
        return orderService.add(addOrderRequest);
    }

    @PutMapping()
    public DataResult<UpdateOrderResponse> update(@Valid @RequestBody UpdateOrderRequest updateOrderRequest){
        return this.orderService.update(updateOrderRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.orderService.delete(id);
    }


    @GetMapping("/getWithPagination")
    public DataResult<Slice<ListOrderResponse>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
    Pageable pageable=PageRequest.of(pageNo-1, pageSize);
    return orderService.getAllWithPagination(pageable);
    }
}
