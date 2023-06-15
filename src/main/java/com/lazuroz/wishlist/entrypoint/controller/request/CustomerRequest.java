package com.lazuroz.wishlist.entrypoint.controller.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String id;
    private String name;
    private String email;
    private String cpf;
}
