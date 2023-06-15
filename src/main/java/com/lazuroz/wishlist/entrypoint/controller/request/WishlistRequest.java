package com.lazuroz.wishlist.entrypoint.controller.request;

import lombok.Data;

@Data
public class WishlistRequest {
    private ProductRequest product;
    private CustomerRequest customer;
}
