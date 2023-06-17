package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.entrypoint.controller.response.ProductResponse;

public class ProductResponseMapper {

    private ProductResponseMapper() {}

    public static ProductResponse toProductResponse(final Product product) {
        if (product == null)
            return null;

        final ProductResponse productResponse = new ProductResponse(
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                product.getValue()
        );

        return productResponse;
    }
}
