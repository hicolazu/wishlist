package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.entrypoint.controller.response.WishlistResponse;

public class WishlistResponseMapper {

    private WishlistResponseMapper() {}

    public static WishlistResponse toWishlistResponse(final Wishlist wishlist) {
        if (wishlist == null)
            return null;

        final WishlistResponse wishlistResponse = new WishlistResponse(
            CustomerResponseMapper.toCustomerResponse(wishlist.getCustomer()),
            wishlist.getProducts().stream().map(ProductResponseMapper::toProductResponse).toList()
        );

        return wishlistResponse;
    }
}
