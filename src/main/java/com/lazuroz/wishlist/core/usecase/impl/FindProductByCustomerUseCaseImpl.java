package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.usecase.FindProductByCustomer;
import com.lazuroz.wishlist.core.usecase.impl.excepion.ProductNotFoundException;

public class FindProductByCustomerUseCaseImpl implements FindProductByCustomer {

    private final FindWishlistByCustomer findWishlistByCustomer;

    public FindProductByCustomerUseCaseImpl(final FindWishlistByCustomer findWishlistByCustomer) {
        this.findWishlistByCustomer = findWishlistByCustomer;
    }

    @Override
    public Product find(final Product product, final Customer customer) {
        var wishlist = findWishlistByCustomer.find(customer);
        return wishlist.getProducts().stream()
                .filter(p -> p.getSku().equals(product.getSku()))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(customer, product));
    }
}
