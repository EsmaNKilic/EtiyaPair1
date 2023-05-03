package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.ProductOrderService;
import com.etiya.ecommercedemopair1.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.requests.order.UpdateOrderRequest;
import com.etiya.ecommercedemopair1.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercedemopair1.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemopair1.core.internationalization.MessageManager;
import com.etiya.ecommercedemopair1.core.internationalization.MessageService;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperManager;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.DataResult;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.repositories.abstracts.CategoryDao;
import com.etiya.ecommercedemopair1.repositories.abstracts.OrderDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderManagerTest {

   OrderManager orderManager;
    OrderDao orderDao;
    ModelMapperService modelMapperService;
    MessageService messageService;
    ProductOrderService productOrderService;

    @BeforeEach
    void setUp() {
        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageService  =  new MessageManager(getBundleMessageSource());
        orderDao = mock(OrderDao.class);
        orderManager = new OrderManager(orderDao, modelMapperService,messageService,productOrderService);
    }

    public ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Test
    void getAll() {

        List<ListOrderResponse> expectedData = new ArrayList<>();
        expectedData.add(new ListOrderResponse(1,"aa",false));
        expectedData.add(new ListOrderResponse(2,"AA",true));
        when(orderDao.findAll()).thenReturn(null);
    }

    @Test
    void update() {


        UpdateOrderRequest updateOrderRequest = new UpdateOrderRequest(1,"aa",false);
        DataResult<UpdateOrderResponse> actualResponse = orderManager.update(updateOrderRequest);

        SuccessDataResult<UpdateOrderResponse> expectedResponse =
                new SuccessDataResult<>(new UpdateOrderResponse(1, "aa",false));

        assert actualResponse.getData().equals(expectedResponse.getData());

    }

}