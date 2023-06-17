package com.lazuroz.wishlist.core.usecase;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Wishlist;

public interface FindWishlistByCustomerUseCase {
    Wishlist find(final Customer customer);
}
