package com.lazuroz.wishlist.dataprovider.repository.mapper;

import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.dataprovider.repository.entity.ProductEntity;

public class ProductEntityMapper {

    private ProductEntityMapper() {}

    public static Product toProduct(final ProductEntity productEntity) {
        if (productEntity == null) return null;

        final Product product = new Product(
                productEntity.getSku(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getValue()
        );

        return product;
    }

    public static ProductEntity toProductEntity(final Product product) {
        if (product == null) return null;

        final ProductEntity productEntity = new ProductEntity(
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                product.getValue()
        );

        return productEntity;
    }
}
