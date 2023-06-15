package com.lazuroz.wishlist.dataprovider.repository;

import com.lazuroz.wishlist.dataprovider.repository.entity.WishlistEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WishlistRepository extends MongoRepository<WishlistEntity, String>  {
    Optional<WishlistEntity> findByCustomerId(String customerId);
}
