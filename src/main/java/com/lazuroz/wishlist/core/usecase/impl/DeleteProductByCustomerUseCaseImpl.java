package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.DeleteProductFromWishlist;
import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.usecase.DeleteProductByCustomerUseCase;

public class DeleteProductByCustomerUseCaseImpl implements DeleteProductByCustomerUseCase {

    private final FindWishlistByCustomer findWishlistByCustomer;
    private final DeleteProductFromWishlist deleteProductFromWishlist;

    public DeleteProductByCustomerUseCaseImpl(final FindWishlistByCustomer findWishlistByCustomer,
                                              final DeleteProductFromWishlist deleteProductFromWishlist) {
        this.findWishlistByCustomer = findWishlistByCustomer;
        this.deleteProductFromWishlist = deleteProductFromWishlist;
    }

    @Override
    public void delete(Customer customer, Product product) {
        var wishlist = findWishlistByCustomer.find(customer);
        deleteProductFromWishlist.delete(wishlist, product);
    }
}
