package com.lazuroz.wishlist.core.usecase;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;

public interface InsertWishlistProductUseCase {
    void insert(final Customer customer, final Product product);
}
