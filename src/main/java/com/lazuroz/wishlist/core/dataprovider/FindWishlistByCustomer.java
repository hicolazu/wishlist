package com.lazuroz.wishlist.core.dataprovider;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Wishlist;

public interface FindWishlistByCustomer {
    Wishlist find(final Customer customer);
}
