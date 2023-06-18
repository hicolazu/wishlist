package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.core.usecase.impl.excepion.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindProductByCustomerUseCaseTest {

    @Mock
    FindWishlistByCustomer findWishlistByCustomer;

    @Test
    void GivenACustomerAndProduct_WhenFindProduct_ThenFind() {
        // GIVEN
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
                .addProduct(product)
                .build();

        FindProductByCustomerUseCaseImpl useCase = new FindProductByCustomerUseCaseImpl(findWishlistByCustomer);

        // WHEN
        when(findWishlistByCustomer.find(customer)).thenReturn(wishlist);
        Product foundProduct = useCase.find(product, customer);

        // THEN
        verify(findWishlistByCustomer, atMostOnce()).find(customer);
        assertEquals(product, foundProduct);
    }

    @Test
    void GivenACustomerWithEmptyWishlist_WhenFindProduct_ThenThrowsNotFoundException() {
        // GIVEN
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

        FindProductByCustomerUseCaseImpl useCase = new FindProductByCustomerUseCaseImpl(findWishlistByCustomer);

        // WHEN
        when(findWishlistByCustomer.find(customer)).thenReturn(wishlist);

        // THEN
        assertThrows(ProductNotFoundException.class, () -> useCase.find(product, customer));
    }
}