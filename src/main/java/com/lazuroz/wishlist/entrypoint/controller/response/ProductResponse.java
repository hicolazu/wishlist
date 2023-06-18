package com.lazuroz.wishlist.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private String sku;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
}
