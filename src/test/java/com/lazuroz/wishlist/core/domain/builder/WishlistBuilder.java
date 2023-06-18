package com.lazuroz.wishlist.core.domain.builder;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.domain.Wishlist;

public class WishlistBuilder {
    private final Wishlist wishlist;

    public WishlistBuilder() {
        this.wishlist = new Wishlist();
    }

    public WishlistBuilder withId(String id) {
        wishlist.setId(id);
        return this;
    }

    public WishlistBuilder withCustomer(Customer customer) {
        wishlist.setCustomer(customer);
        return this;
    }

    public WishlistBuilder withProduct(Product product) {
        wishlist.getProducts().add(product);
        return this;
    }

    public WishlistBuilder addProduct(Product product) {
        wishlist.getProducts().add(product);
        return this;
    }

    public Wishlist build() {
        return this.wishlist;
    }
}
