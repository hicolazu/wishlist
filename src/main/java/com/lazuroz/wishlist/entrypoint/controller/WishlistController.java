package com.lazuroz.wishlist.entrypoint.controller;

import com.lazuroz.wishlist.core.usecase.DeleteProductByCustomerUseCase;
import com.lazuroz.wishlist.core.usecase.FindProductByCustomer;
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

    @Autowired
    private FindProductByCustomer findProductByCustomer;

    @Autowired
    private DeleteProductByCustomerUseCase deleteProductByCustomerUseCase;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid final WishlistRequest wishlistRequest) {
        var customer = CustomerRequestMapper.toCustomer(wishlistRequest.getCustomer());
        var product = ProductRequestMapper.toProduct(wishlistRequest.getProduct());
        insertWishlistProductUseCase.insert(customer, product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> findAllByCustomerId(@PathVariable final String customerId) {
        var customer = CustomerRequestMapper.toCustomer(customerId);
        var wishlist = findWishlistByCustomerUseCase.find(customer);
        var wishlistResponse = WishlistResponseMapper.toWishlistResponse(wishlist);
        return ResponseEntity.ok(wishlistResponse);
    }

    @GetMapping
    public ResponseEntity<?> findProductByCustomerId(@RequestParam final String customerId,
                                                     @RequestParam final String sku) {
        var customer = CustomerRequestMapper.toCustomer(customerId);
        var productRequest = ProductRequestMapper.toProduct(sku);
        var productResponse = findProductByCustomer.find(productRequest, customer);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProductFromWishlist(@RequestParam final String customerId,
                                                       @RequestParam final String sku) {
        var customer = CustomerRequestMapper.toCustomer(customerId);
        var product = ProductRequestMapper.toProduct(sku);
        deleteProductByCustomerUseCase.delete(customer, product);
        return ResponseEntity.ok().build();
    }
}
