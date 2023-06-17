package com.lazuroz.wishlist.config;

import com.lazuroz.wishlist.core.usecase.impl.FindProductByCustomerImpl;
import com.lazuroz.wishlist.dataprovider.FindWishlistByCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCustomerConfig {

    @Bean
    public FindProductByCustomerImpl findProductByCustomerImpl(
            FindWishlistByCustomerImpl findWishlistByCustomerImpl
    ) {
        return new FindProductByCustomerImpl(findWishlistByCustomerImpl);
    }
}
