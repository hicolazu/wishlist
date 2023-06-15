package com.lazuroz.wishlist.config;

import com.lazuroz.wishlist.core.usecase.impl.InsertWishlistProductUseCaseImpl;
import com.lazuroz.wishlist.dataprovider.FindWishlistByCustomerImpl;
import com.lazuroz.wishlist.dataprovider.InsertWishlistProductImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertWishlistProductConfig {

    @Bean
    public InsertWishlistProductUseCaseImpl insertWishlistProductUseCaseImpl(
            FindWishlistByCustomerImpl findWishlistByCustomer,
            InsertWishlistProductImpl insertWishlistProduct
    ) {
        return new InsertWishlistProductUseCaseImpl(findWishlistByCustomer, insertWishlistProduct);
    }
}
