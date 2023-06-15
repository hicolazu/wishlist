package com.lazuroz.wishlist.entrypoint.controller.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String sku;
    private String name;
    private String description;
    private String imageUrl;
    private Double value;
}
