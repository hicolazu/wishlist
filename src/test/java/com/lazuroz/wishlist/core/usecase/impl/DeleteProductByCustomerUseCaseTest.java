package com.lazuroz.wishlist.core.usecase.impl;

import com.lazuroz.wishlist.core.dataprovider.DeleteProductFromWishlist;
import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteProductByCustomerUseCaseTest {

    @Mock
    FindWishlistByCustomer findWishlistByCustomer;

    @Mock
    DeleteProductFromWishlist deleteProductFromWishlist;

    @Test
    void GivenACustomerAndProduct_WhenDeleteProductFromWishlist_ThenDelete() {
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

        DeleteProductByCustomerUseCaseImpl useCase = new DeleteProductByCustomerUseCaseImpl(findWishlistByCustomer, deleteProductFromWishlist);

        // WHEN
        when(findWishlistByCustomer.find(customer)).thenReturn(wishlist);
        useCase.delete(customer, product);

        // THEN
        verify(deleteProductFromWishlist, atMostOnce()).delete(wishlist, product);
    }
}