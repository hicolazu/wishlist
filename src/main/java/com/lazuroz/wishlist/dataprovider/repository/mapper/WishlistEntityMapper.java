package com.lazuroz.wishlist.dataprovider.repository.mapper;

import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.dataprovider.repository.entity.WishlistEntity;

import java.util.stream.Collectors;

public class WishlistEntityMapper {

    private WishlistEntityMapper() {}

    public static Wishlist toWishlist(WishlistEntity wishlistEntity) {
        if (wishlistEntity == null) return null;

        final Wishlist wishlist = new Wishlist(
                wishlistEntity.getId(),
                CustomerEntityMapper.toCustomer(wishlistEntity.getCustomer()),
                wishlistEntity.getProducts().stream().map(ProductEntityMapper::toProduct).collect(Collectors.toList())
        );

        return wishlist;
    }

    public static WishlistEntity toWishlistEntity(Wishlist wishlist) {
        if (wishlist == null) return null;

        final WishlistEntity wishlistEntity = new WishlistEntity(
                wishlist.getId(),
                CustomerEntityMapper.toCustomerEntity(wishlist.getCustomer()),
                wishlist.getProducts().stream().map(ProductEntityMapper::toProductEntity).collect(Collectors.toList())
        );

        return wishlistEntity;
    }
}
