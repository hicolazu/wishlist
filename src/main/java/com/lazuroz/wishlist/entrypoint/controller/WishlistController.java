package com.lazuroz.wishlist.entrypoint.controller;

import com.lazuroz.wishlist.core.usecase.FindWishlistByCustomerUseCase;
import com.lazuroz.wishlist.core.usecase.InsertWishlistProductUseCase;
import com.lazuroz.wishlist.entrypoint.controller.mapper.CustomerRequestMapper;
import com.lazuroz.wishlist.entrypoint.controller.mapper.ProductRequestMapper;
import com.lazuroz.wishlist.entrypoint.controller.mapper.WishlistResponseMapper;
import com.lazuroz.wishlist.entrypoint.controller.request.WishlistRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wishlists")
@Validated
public class WishlistController {

    @Autowired
    private InsertWishlistProductUseCase insertWishlistProductUseCase;

    @Autowired
    private FindWishlistByCustomerUseCase findWishlistByCustomerUseCase;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid final WishlistRequest wishlistRequest) {
        var customer = CustomerRequestMapper.toCustomer(wishlistRequest.getCustomer());
        var product = ProductRequestMapper.toProduct(wishlistRequest.getProduct());
        insertWishlistProductUseCase.insert(customer, product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllByCustomerId(@RequestParam final String customerId) {
        var customer = CustomerRequestMapper.toCustomer(customerId);
        var wishlist = findWishlistByCustomerUseCase.find(customer);
        var wishlistResponse = WishlistResponseMapper.toWishlistResponse(wishlist);
        return ResponseEntity.ok(wishlistResponse);
    }
}
