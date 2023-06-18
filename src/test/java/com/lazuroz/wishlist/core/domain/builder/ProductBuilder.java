package com.lazuroz.wishlist.core.domain.builder;

import com.lazuroz.wishlist.core.domain.Product;

public class ProductBuilder {
    private final Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public ProductBuilder withSku(String sku) {
        product.setSku(sku);
        return this;
    }

    public ProductBuilder withName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder withDescription(String description) {
        product.setDescription(description);
        return this;
    }

    public ProductBuilder withImageUrl(String imageUrl) {
        product.setImageUrl(imageUrl);
        return this;
    }

    public ProductBuilder withPrice(Double price) {
        product.setPrice(price);
        return this;
    }

    public Product build() {
        return this.product;
    }
}