package com.lazuroz.wishlist.core.dataprovider;

import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.domain.Wishlist;

public interface DeleteProductFromWishlist {
    void delete(final Wishlist wishlist, final Product product);
}
