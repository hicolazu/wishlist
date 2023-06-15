package com.lazuroz.wishlist.dataprovider.repository.entity;

import lombok.Data;

@Data
public class ProductEntity {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private Double value;
}
