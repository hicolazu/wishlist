package com.lazuroz.wishlist.core.usecase.impl.excepion;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;

public class WishlistFullException extends RuntimeException {

    public WishlistFullException(final Customer customer, final Product product) {
        super(String.format("Wishlist of customer %s is full. Product %s cannot be added", customer.getId(), product.getSku()));
    }
}
