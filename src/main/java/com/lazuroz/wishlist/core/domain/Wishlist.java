package com.lazuroz.wishlist.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private String id;
    private Customer customer;
    private List<Product> products = new ArrayList<>();

    public Wishlist() {
    }

    public Wishlist(String id, Customer customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
