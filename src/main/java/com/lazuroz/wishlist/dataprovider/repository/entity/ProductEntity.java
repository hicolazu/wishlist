package com.lazuroz.wishlist.dataprovider.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEntity {
    private String sku;
    private String name;
    private String description;
    private String imageUrl;
    private Double value;
}
