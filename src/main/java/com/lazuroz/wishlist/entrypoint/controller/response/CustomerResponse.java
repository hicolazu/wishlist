package com.lazuroz.wishlist.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponse {
    private String id;
    private String name;
    private String email;
    private String cpf;
}
