package com.lazuroz.wishlist.config;

import com.lazuroz.wishlist.core.usecase.impl.DeleteProductByCustomerUseCaseImpl;
import com.lazuroz.wishlist.dataprovider.DeleteProductFromWishlistImpl;
import com.lazuroz.wishlist.dataprovider.FindWishlistByCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductByCustomerConfig {

    @Bean
    public DeleteProductByCustomerUseCaseImpl deleteProductByCustomerUseCaseImpl(
            FindWishlistByCustomerImpl findWishlistByCustomerImpl,
            DeleteProductFromWishlistImpl deleteProductFromWishlistImpl
    ) {
        return new DeleteProductByCustomerUseCaseImpl(findWishlistByCustomerImpl, deleteProductFromWishlistImpl);
    }
}
