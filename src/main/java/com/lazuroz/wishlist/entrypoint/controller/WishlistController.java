package com.lazuroz.wishlist.entrypoint.controller;

import com.lazuroz.wishlist.core.usecase.InsertWishlistProductUseCase;
import com.lazuroz.wishlist.entrypoint.controller.mapper.CustomerRequestMapper;
import com.lazuroz.wishlist.entrypoint.controller.mapper.ProductRequestMapper;
import com.lazuroz.wishlist.entrypoint.controller.request.WishlistRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wishlists")
@Validated
public class WishlistController {

    @Autowired
    private InsertWishlistProductUseCase insertWishlistProductUseCase;

    @Autowired
    private CustomerRequestMapper customerRequestMapper;

    @Autowired
    private ProductRequestMapper productRequestMapper;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid final WishlistRequest wishlistRequest) {
        var customer = customerRequestMapper.toCustomer(wishlistRequest.getCustomer());
        var product = productRequestMapper.toProduct(wishlistRequest.getProduct());
        insertWishlistProductUseCase.insert(customer, product);
        return ResponseEntity.ok().build();
    }
}
