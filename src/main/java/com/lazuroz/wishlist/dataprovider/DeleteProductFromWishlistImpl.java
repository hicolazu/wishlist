package com.lazuroz.wishlist.dataprovider;

import com.lazuroz.wishlist.core.dataprovider.DeleteProductFromWishlist;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import com.lazuroz.wishlist.dataprovider.repository.mapper.WishlistEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductFromWishlistImpl implements DeleteProductFromWishlist {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public void delete(Wishlist wishlist, Product product) {
        wishlist.getProducts().removeIf(p -> p.getSku().equals(product.getSku()));
        var entity = WishlistEntityMapper.toWishlistEntity(wishlist);
        wishlistRepository.save(entity);
    }
}
