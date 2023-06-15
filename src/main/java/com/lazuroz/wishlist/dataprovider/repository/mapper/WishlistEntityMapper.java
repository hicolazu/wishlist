package com.lazuroz.wishlist.dataprovider.repository.mapper;

import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.dataprovider.repository.entity.WishlistEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WishlistEntityMapper {
    Wishlist toDomain(WishlistEntity wishlistEntity);
}
