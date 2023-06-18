package com.lazuroz.wishlist.entrypoint.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WishlistRequest {

    @NotNull
    private ProductRequest product;

    @NotNull
    private CustomerRequest customer;
}
