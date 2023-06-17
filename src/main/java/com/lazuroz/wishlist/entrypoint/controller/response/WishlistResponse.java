package com.lazuroz.wishlist.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WishlistResponse {
    private CustomerResponse customer;
    private List<ProductResponse> products;
}
