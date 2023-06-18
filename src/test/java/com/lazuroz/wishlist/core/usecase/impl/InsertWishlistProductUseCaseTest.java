package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.core.usecase.InsertWishlistProductUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsertWishlistProductUseCaseTest {

    @Mock
    FindWishlistByCustomer findWishlistByCustomer;

    @Mock
    InsertWishlistProduct insertWishlistProduct;

    @Test
    void GivenACustomerAndProduct_WhenInsertWishlistProduct_ThenInsert() {
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

        InsertWishlistProductUseCase useCase = new InsertWishlistProductUseCaseImpl(findWishlistByCustomer, insertWishlistProduct);

        // WHEN
        when(findWishlistByCustomer.find(customer)).thenReturn(wishlist);

        useCase.insert(customer, product);

        // THEN
        verify(insertWishlistProduct, atMostOnce()).insert(wishlist, product);
    }

}