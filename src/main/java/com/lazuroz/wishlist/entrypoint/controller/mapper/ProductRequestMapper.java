package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.entrypoint.controller.request.ProductRequest;

public class ProductRequestMapper {

    private ProductRequestMapper() {}

    public static Product toProduct(final ProductRequest productRequest) {
        if (productRequest == null) return null;

        final Product product = new Product(
                productRequest.getSku(),
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getImageUrl(),
                productRequest.getValue()
        );

        return product;
    }
}
