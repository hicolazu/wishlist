package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.entrypoint.controller.request.CustomerRequest;

public class CustomerRequestMapper {

    private CustomerRequestMapper() {}

    public static Customer toCustomer(final CustomerRequest customerRequest) {
        if (customerRequest == null)
            return null;

        final Customer customer = new Customer(
                customerRequest.getId(),
                customerRequest.getName(),
                customerRequest.getEmail(),
                customerRequest.getCpf()
        );

        return customer;
    }

    public static Customer toCustomer(final String customerId) {
        if (customerId == null)
            return null;

        final Customer customer = new Customer();
        customer.setId(customerId);

        return customer;
    }
}
