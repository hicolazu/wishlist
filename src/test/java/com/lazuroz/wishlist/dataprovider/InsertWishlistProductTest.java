package com.lazuroz.wishlist.dataprovider;

import com.lazuroz.wishlist.AbstractIntegrationTest;
import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertWishlistProductTest extends AbstractIntegrationTest {

    @Autowired
    private InsertWishlistProduct insertWishlistProduct;

    @Autowired
    private WishlistRepository wishlistRepository;

    @AfterEach
    void tearDown() {
        wishlistRepository.deleteAll();
    }

    @Test
    void GivenNewWishlistAndProduct_whenInsertingAProduct_thenTheProductIsAddedToTheWishlist() {
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
                .withId(null)
                .withCustomer(customer)
                .build();

        // When
        insertWishlistProduct.insert(wishlist, product);

        // Then
        var wishlistEntity = wishlistRepository.findByCustomerId(wishlist.getCustomer().getId()).get();
        assertEquals(1, wishlistEntity.getProducts().size());
        assertEquals(product.getSku(), wishlistEntity.getProducts().get(0).getSku());
        assertEquals(customer.getId(), wishlistEntity.getCustomer().getId());
        assertNotNull(wishlistEntity.getId());
    }

    @Test
    void GivenANonEmptyWishlistAndAProduct_whenInsertingAProduct_thenTheProductIsAddedToTheWishlist() {
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

        var newProduct = new ProductBuilder()
                .withSku("2")
                .withName("Product 2")
                .withDescription("Description 2")
                .withPrice(5.0)
                .build();

        // When
        insertWishlistProduct.insert(wishlist, newProduct);

        // Then
        var wishlistEntity = wishlistRepository.findByCustomerId(wishlist.getCustomer().getId()).get();
        assertEquals(2, wishlistEntity.getProducts().size());
        assertEquals(customer.getId(), wishlistEntity.getCustomer().getId());
    }
}