package com.lazuroz.wishlist.dataprovider.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerEntity {
    private String id;
    private String name;
    private String email;
    private String cpf;
}
