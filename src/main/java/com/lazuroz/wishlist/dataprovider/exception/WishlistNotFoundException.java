package com.lazuroz.wishlist.dataprovider.exception;

import com.lazuroz.wishlist.core.domain.Customer;

public class WishlistNotFoundException extends RuntimeException {
    public WishlistNotFoundException(final Customer customer) {
        super("Wishlist not found for customer " + customer.getId() + ".");
    }
}
