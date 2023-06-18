package com.lazuroz.wishlist.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private boolean error = true;
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
