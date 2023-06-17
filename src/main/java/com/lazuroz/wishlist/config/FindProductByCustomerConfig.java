package com.lazuroz.wishlist.config;

import com.lazuroz.wishlist.core.usecase.impl.FindProductByCustomerUseCaseImpl;
import com.lazuroz.wishlist.dataprovider.FindWishlistByCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCustomerConfig {

    @Bean
    public FindProductByCustomerUseCaseImpl findProductByCustomerImpl(
            FindWishlistByCustomerImpl findWishlistByCustomerImpl
    ) {
        return new FindProductByCustomerUseCaseImpl(findWishlistByCustomerImpl);
    }
}
