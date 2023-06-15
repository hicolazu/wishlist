package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.usecase.InsertWishlistProductUseCase;

public class InsertWishlistProductUseCaseImpl implements InsertWishlistProductUseCase {

    private final FindWishlistByCustomer findWishlistByCustomer;
    private final InsertWishlistProduct insertWishlistProduct;

    public InsertWishlistProductUseCaseImpl(final FindWishlistByCustomer findWishlistByCustomer,
                                            final InsertWishlistProduct insertWishlistProduct) {
        this.findWishlistByCustomer = findWishlistByCustomer;
        this.insertWishlistProduct = insertWishlistProduct;
    }

    @Override
    public void insert(Customer customer, Product product) {
        var wishlist = findWishlistByCustomer.find(customer);
        insertWishlistProduct.insert(wishlist, product);
    }
}
