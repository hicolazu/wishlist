package com.lazuroz.wishlist.dataprovider.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Document(collection = "wishlist")
public class WishlistEntity {
    @Id private String id;
    private CustomerEntity customer;
    private List<ProductEntity> products;
//    @CreatedDate private OffsetDateTime dateCreated;
//    @LastModifiedDate private OffsetDateTime lastUpdated;
//    @Version private Integer version;
}
