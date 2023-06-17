package com.lazuroz.wishlist.core.usecase.impl.excepion;

import com.lazuroz.wishlist.core.domain.Customer;
import com.lazuroz.wishlist.core.domain.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(final Customer customer, final Product product) {
        super(String.format("Product %s not found in wishlist of customer %s", product.getSku(), customer.getId()));
    }
}
