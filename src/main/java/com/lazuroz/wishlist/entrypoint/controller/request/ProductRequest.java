package com.lazuroz.wishlist.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String sku;

    @NotBlank
    private String name;

    private String description;

    private String imageUrl;

    @NotBlank
    private Double price;
}
