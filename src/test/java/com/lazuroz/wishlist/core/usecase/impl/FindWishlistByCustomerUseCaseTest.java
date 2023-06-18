package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.core.usecase.FindWishlistByCustomerUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindWishlistByCustomerUseCaseTest {

    @Mock
    FindWishlistByCustomer findWishlistByCustomer;

    @Test
    void GivenACustomer_WhenFindWishlist_ThenFind() {
        // GIVEN
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

        FindWishlistByCustomerUseCase useCase = new FindWishlistByCustomerUseCaseImpl(findWishlistByCustomer);

        // WHEN
        when(findWishlistByCustomer.find(customer)).thenReturn(expectedWishlist);
        var actualWishlist = useCase.find(customer);

        // THEN
        verify(findWishlistByCustomer, atMostOnce()).find(customer);
        assertEquals(expectedWishlist, actualWishlist);
    }
}