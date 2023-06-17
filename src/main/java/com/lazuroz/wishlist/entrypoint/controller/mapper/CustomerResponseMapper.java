package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.entrypoint.controller.response.CustomerResponse;

public class CustomerResponseMapper {

    private CustomerResponseMapper() {}

    public static CustomerResponse toCustomerResponse(final Customer customer) {
        if (customer == null)
            return null;

        final CustomerResponse customerResponse = new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getCpf()
        );

        return customerResponse;
    }
}
