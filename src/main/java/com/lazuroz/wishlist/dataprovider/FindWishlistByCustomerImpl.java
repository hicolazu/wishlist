package com.lazuroz.wishlist.dataprovider;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import com.lazuroz.wishlist.dataprovider.repository.mapper.WishlistEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FindWishlistByCustomerImpl implements FindWishlistByCustomer {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistEntityMapper wishlistEntityMapper;

    @Override
    public Wishlist find(Customer customer) {
        return wishlistRepository
                .findByCustomerId(customer.getId())
                .map(wishlistEntityMapper::toWishlist)
                .orElse(new Wishlist(null, customer, new ArrayList<>()));
    }
}
