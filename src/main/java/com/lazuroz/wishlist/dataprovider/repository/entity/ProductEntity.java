package com.lazuroz.wishlist.dataprovider.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class ProductEntity {
    @Id
    private String sku;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
}
