package com.lazuroz.wishlist.dataprovider.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "wishlist")
public class WishlistEntity {
    @Id private String id;
    private CustomerEntity customer;
    private List<ProductEntity> products;
    @CreatedDate private LocalDateTime createdDate;
    @LastModifiedDate private LocalDateTime lastModifiedDate;

    public WishlistEntity(String id, CustomerEntity customer, List<ProductEntity> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    @PersistenceCreator
    public WishlistEntity(String id,
                          CustomerEntity customer,
                          List<ProductEntity> products,
                          LocalDateTime createdDate,
                          LocalDateTime lastModifiedDate) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
