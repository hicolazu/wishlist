package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.domain.Wishlist;
import com.lazuroz.wishlist.core.usecase.FindWishlistByCustomerUseCase;


import java.util.List;

public class FindWishlistByCustomerUseCaseImpl implements FindWishlistByCustomerUseCase {

    private final FindWishlistByCustomer findWishlistByCustomer;

    public FindWishlistByCustomerUseCaseImpl(FindWishlistByCustomer findWishlistByCustomer) {
        this.findWishlistByCustomer = findWishlistByCustomer;
    }

    @Override
    public Wishlist find(Customer customer) {
        return findWishlistByCustomer.find(customer);
    }
}
