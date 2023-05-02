package com.etiya.ecommercedemopair1.business.concrate;

import com.etiya.ecommercedemopair1.business.abstracts.ProductOrderService;
import com.etiya.ecommercedemopair1.business.dtos.requests.ProductOrder.AddProductOrderRequest;
import com.etiya.ecommercedemopair1.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemopair1.core.utils.results.Result;
import com.etiya.ecommercedemopair1.core.utils.results.SuccessResult;
import com.etiya.ecommercedemopair1.entities.concretes.Order;
import com.etiya.ecommercedemopair1.entities.concretes.ProductOrder;
import com.etiya.ecommercedemopair1.repositories.abstracts.ProductOrderDao;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;

import java.util.List;

public class ProductOrderManager implements ProductOrderService {
    private ProductOrderDao productOrderDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


    @Override
    public Result addRange(int orderId, List<AddProductOrderRequest> addProductOrderRequest) {
        for (AddProductOrderRequest request: addProductOrderRequest) {
            ProductOrder detail = modelMapperService.getMapper.map(request, ProductOrder.class);
            Order order = new Order();
            order.setId(orderId);
            detail.setOrder(order);
            productOrderDao.save(detail);
        }
        return new SuccessResult();
    }
    }
}
