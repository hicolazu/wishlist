package com.lazuroz.wishlist.dataprovider;

import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import com.lazuroz.wishlist.dataprovider.repository.mapper.WishlistEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertWishlistProductImpl implements InsertWishlistProduct {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistEntityMapper wishlistEntityMapper;

    @Override
    public void insert(Wishlist wishlist, Product product) {
        wishlist.getProducts().add(product);
        var wishlistEntity = wishlistEntityMapper.toEntity(wishlist);
        wishlistRepository.save(wishlistEntity);
    }
}
