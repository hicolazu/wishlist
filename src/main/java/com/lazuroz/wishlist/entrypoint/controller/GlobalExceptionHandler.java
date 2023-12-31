package com.lazuroz.wishlist.entrypoint.controller;

import com.lazuroz.wishlist.core.usecase.impl.excepion.ProductNotFoundException;
import com.lazuroz.wishlist.core.usecase.impl.excepion.WishlistFullException;
import com.lazuroz.wishlist.entrypoint.controller.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${swagger.openapi.email}")
    private String email;

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(final ProductNotFoundException exception) {
        final ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        LOGGER.warn(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(final MissingServletRequestParameterException exception) {
        final ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        LOGGER.warn(exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WishlistFullException.class)
    public ResponseEntity<?> handleWishlistFullException(final WishlistFullException exception) {
        final ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        LOGGER.warn(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(final Exception exception) {
        final ErrorResponse errorResponse = new ErrorResponse("Internal server error. Please contact " + email + ".");
        LOGGER.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
