package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.entrypoint.controller.request.CustomerRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {
    Customer toCustomer(CustomerRequest customerRequest);
}
