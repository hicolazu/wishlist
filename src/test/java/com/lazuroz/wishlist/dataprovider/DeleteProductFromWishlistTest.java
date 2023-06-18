package com.lazuroz.wishlist.dataprovider;

import com.lazuroz.wishlist.AbstractIntegrationTest;
import com.lazuroz.wishlist.core.dataprovider.DeleteProductFromWishlist;
import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DeleteProductFromWishlistTest extends AbstractIntegrationTest {

    @Autowired
    DeleteProductFromWishlist deleteProductFromWishlist;

    @Autowired
    InsertWishlistProduct insertWishlistProduct;

    @Autowired
    WishlistRepository wishlistRepository;

    @AfterEach
    void tearDown() {
        wishlistRepository.deleteAll();
    }

    @Test
    void GivenWishlistWithProduct_whenDeletingAProduct_thenTheProductIsRemovedFromTheWishlist() {
        // Given
        var customer = new CustomerBuilder()
                .withId("1")
                .withName("John")
                .withEmail("john@mail.com")
                .withCpf("12345678900")
                .build();

        var product = new ProductBuilder()
                .withSku("1")
                .withName("Product 1")
                .withDescription("Description 1")
                .withPrice(10.0)
                .build();

        var wishlist = new WishlistBuilder()
                .withId("1")
                .withCustomer(customer)
                .build();

        insertWishlistProduct.insert(wishlist, product);

        // When
        deleteProductFromWishlist.delete(wishlist, product);

        // Then
        var wishlistEntity = wishlistRepository.findByCustomerId(wishlist.getCustomer().getId()).get();
        assertEquals(0, wishlistEntity.getProducts().size());
        assertEquals(wishlist.getCustomer().getId(), wishlistEntity.getCustomer().getId());
    }

    @Test
    void GivenWishlistWithProduct_whenDeletingANonWishlistProduct_thenTheProductIsNotRemovedFromTheWishlist() {
        // Given
        var customer = new CustomerBuilder()
                .withId("1")
                .withName("John")
                .withEmail("john@mail.com")
                .withCpf("12345678900")
                .build();

        var product = new ProductBuilder()
                .withSku("1")
                .withName("Product 1")
                .withDescription("Description 1")
                .withPrice(10.0)
                .build();

        var wishlist = new WishlistBuilder()
                .withId("1")
                .withCustomer(customer)
                .build();

        insertWishlistProduct.insert(wishlist, product);

        // When
        var product2 = new ProductBuilder()
                .withSku("2")
                .withName("Product 2")
                .withDescription("Description 2")
                .withPrice(4.0)
                .build();

        deleteProductFromWishlist.delete(wishlist, product2);

        // Then
        var wishlistEntity = wishlistRepository.findByCustomerId(wishlist.getCustomer().getId()).get();
        assertEquals(1, wishlistEntity.getProducts().size());
        assertEquals(wishlist.getCustomer().getId(), wishlistEntity.getCustomer().getId());
    }


}