package com.lazuroz.wishlist.config;

import com.lazuroz.wishlist.core.usecase.impl.FindWishlistByCustomerUseCaseImpl;
import com.lazuroz.wishlist.dataprovider.FindWishlistByCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindWishlistByCustomerConfig {

    @Bean
    public FindWishlistByCustomerUseCaseImpl findAllProductsByCustomerImpl(
            FindWishlistByCustomerImpl findWishlistByCustomerImpl
    ) {
        return new FindWishlistByCustomerUseCaseImpl(findWishlistByCustomerImpl);
    }
}
