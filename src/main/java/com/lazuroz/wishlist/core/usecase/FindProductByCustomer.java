package com.lazuroz.wishlist.core.usecase;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;

public interface FindProductByCustomer {
    Product find(final Product product, final Customer customer);
}
