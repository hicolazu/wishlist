package com.lazuroz.wishlist.dataprovider.repository.mapper;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.dataprovider.repository.entity.CustomerEntity;

public class CustomerEntityMapper {

    private CustomerEntityMapper() {}

    public static Customer toCustomer(final CustomerEntity customerEntity) {
        if (customerEntity == null) return null;

        final Customer customer = new Customer(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getEmail(),
                customerEntity.getCpf()
        );

        return customer;
    }

    public static CustomerEntity toCustomerEntity(final Customer customer) {
        if (customer == null) return null;

        final CustomerEntity customerEntity = new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getCpf()
        );

        return customerEntity;
    }
}
