package com.etiya.ecommercedemopair1.core.utils.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();;
}
