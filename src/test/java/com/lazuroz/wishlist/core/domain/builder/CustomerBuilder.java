package com.lazuroz.wishlist.core.domain.builder;

import com.lazuroz.wishlist.core.domain.Customer;

public class CustomerBuilder {
    private final Customer customer;

    public CustomerBuilder() {
        this.customer = new Customer();
    }

    public CustomerBuilder withId(String id) {
        customer.setId(id);
        return this;
    }

    public CustomerBuilder withName(String name) {
        customer.setName(name);
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public CustomerBuilder withCpf(String cpf) {
        customer.setCpf(cpf);
        return this;
    }

    public Customer build() {
        return this.customer;
    }
}
