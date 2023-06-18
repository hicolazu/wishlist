package com.lazuroz.wishlist.dataprovider;

import com.lazuroz.wishlist.AbstractIntegrationTest;
import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class FindWishlistByCustomerTest extends AbstractIntegrationTest {

    @Autowired
    FindWishlistByCustomer findWishlistByCustomer;

    @Autowired
    InsertWishlistProduct insertWishlistProduct;

    @Autowired
    WishlistRepository wishlistRepository;

    @AfterEach
    void tearDown() {
        wishlistRepository.deleteAll();
    }

    @Test
    void GivenWishlistWithProduct_whenFindingWishlistByCustomer_thenTheWishlistIsReturned() {
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

        // WHEN
        var wishlistFound = findWishlistByCustomer.find(customer);

        // THEN
        assertEquals(wishlist.getId(), wishlistFound.getId());
        assertEquals(1, wishlistFound.getProducts().size());
        assertEquals(customer.getId(), wishlistFound.getCustomer().getId());
    }

    @Test
    void GivenACustomerWithoutWishlist_whenFindingWishlistByCustomer_thenANewWishlistIsReturned() {
        // Given
        var customer = new CustomerBuilder()
                .withId("1")
                .withName("John")
                .withEmail("john@mail.com")
                .withCpf("12345678900")
                .build();

        var expectedWishlist = new WishlistBuilder()
                .withId(null)
                .withCustomer(customer)
                .build();

        // WHEN
        var wishlist = findWishlistByCustomer.find(customer);

        // THEN
        assertEquals(expectedWishlist.getId(), wishlist.getId());
        assertEquals(0, wishlist.getProducts().size());
        assertEquals(customer.getId(), wishlist.getCustomer().getId());
    }

}