package com.lazuroz.wishlist.entrypoint.controller;

import com.lazuroz.wishlist.AbstractIntegrationTest;
import com.lazuroz.wishlist.JsonPayloadUtils;
import com.lazuroz.wishlist.core.dataprovider.FindWishlistByCustomer;
import com.lazuroz.wishlist.core.dataprovider.InsertWishlistProduct;
import com.lazuroz.wishlist.core.domain.builder.CustomerBuilder;
import com.lazuroz.wishlist.core.domain.builder.ProductBuilder;
import com.lazuroz.wishlist.core.domain.builder.WishlistBuilder;
import com.lazuroz.wishlist.dataprovider.repository.WishlistRepository;
import com.lazuroz.wishlist.entrypoint.controller.response.ErrorResponse;
import com.lazuroz.wishlist.entrypoint.controller.response.ProductResponse;
import com.lazuroz.wishlist.entrypoint.controller.response.WishlistResponse;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class WishlistControllerTest extends AbstractIntegrationTest {

    static final String BASE_URI = "http://localhost";

    @LocalServerPort
    int port;

    @Autowired
    InsertWishlistProduct insertWishlistProduct;

    @Autowired
    FindWishlistByCustomer findWishlistByCustomer;

    @Autowired
    WishlistRepository wishlistRepository;

    @BeforeEach
    void beforeEach() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
    }

    @AfterEach
    void tearDown() {
        wishlistRepository.deleteAll();
    }

    @Test
    void GivenACustomerAndAProduct_WhenRequestToCreateWishlist_ThenSuccess() {
        // GIVEN
        String requestPayload = JsonPayloadUtils.getJsonPayload("scenarios/create-wishlist.json");

        // WHEN
        RestAssured.given()
                .log()
                .all()
                .contentType("application/json")
                .body(requestPayload)
                .when()
                .post("api/v1/wishlists")
                .then()
                // THEN
                .assertThat()
                .statusCode(200);
    }

    @Test
    void GivenACustomer_WhenRequestToFindWishlist_ThenSuccess() {
        // GIVEN
        var customer = new CustomerBuilder()
                .withId("1")
                .withName("John")
                .withEmail("john@mail.com")
                .withCpf("12345678900")
                .build();

        var product = new ProductBuilder()
                .withSku("1")
                .withName("Product 1")
                .withDescription("Description 1")
                .withPrice(10.0)
                .build();

        var wishlist = new WishlistBuilder()
                .withId("1")
                .withCustomer(customer)
                .build();

        insertWishlistProduct.insert(wishlist, product);

        // WHEN
        var response = RestAssured.given()
                .log()
                .all()
                .when()
                .get("api/v1/wishlists/" + customer.getId())
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(WishlistResponse.class);

        // THEN
        assertEquals(customer.getId(), response.getCustomer().getId());
        assertEquals(1, response.getProducts().size());
    }

    @Test
    void GivenACustomerAndAProduct_WhenRequestToFindProductFromWishlist_ThenSuccess() {
        // GIVEN
        var customer = new CustomerBuilder()
                .withId("1")
                .withName("John")
                .withEmail("john@mail.com")
                .withCpf("12345678900")
                .build();

        var product = new ProductBuilder()
                .withSku("1")
                .withName("Product 1")
                .withDescription("Description 1")
                .withPrice(10.0)
                .build();

        var wishlist = new WishlistBuilder()
                .withId("1")
                .withCustomer(customer)
                .build();

        insertWishlistProduct.insert(wishlist, product);

        // WHEN
        var response = RestAssured.given()
                .log()
                .all()
                .when()
                .queryParam("sku", product.getSku())
                .queryParam("customerId", customer.getId())
                .get("api/v1/wishlists")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(ProductResponse.class);

        // THEN
        assertEquals(product.getSku(), response.getSku());
        assertEquals(product.getName(), response.getName());
        assertEquals(product.getDescription(), response.getDescription());
        assertEquals(product.getPrice(), response.getPrice());
    }

    @Test
    void GivenACustomerAndAProduct_WhenRequestToFindProductNotFromWishlist_ThenReturnError() {
        // GIVEN
        var sku = "1";
        var customerId = "1";

        // WHEN
        var errorResponse = RestAssured.given()
                .log()
                .all()
                .when()
                .queryParam("sku", sku)
                .queryParam("customerId", customerId)
                .get("api/v1/wishlists")
                .then()
                // THEN
                .assertThat()
                .statusCode(404)
                .extract()
                .body()
                .as(ErrorResponse.class);

        // THEN
        assertTrue(errorResponse.isError());
    }

    @Test
    void GivenACustomerAndAProduct_WhenRequestToDeleteProductFromWishlist_ThenSuccess() {
        // GIVEN
        var customer = new CustomerBuilder()
                .withId("1")
                .withName("John")
                .withEmail("john@mail.com")
                .withCpf("12345678900")
                .build();

        var product = new ProductBuilder()
                .withSku("1")
                .withName("Product 1")
                .withDescription("Description 1")
                .withPrice(10.0)
                .build();

        var wishlist = new WishlistBuilder()
                .withId("1")
                .withCustomer(customer)
                .build();

        insertWishlistProduct.insert(wishlist, product);

        // WHEN
        RestAssured.given()
                .log()
                .all()
                .when()
                .queryParam("sku", product.getSku())
                .queryParam("customerId", customer.getId())
                .delete("api/v1/wishlists")
                .then()
                .assertThat()
                .statusCode(200);

        // THEN
        wishlist = findWishlistByCustomer.find(customer);
        assertEquals(0, wishlist.getProducts().size());
        assertEquals(customer.getId(), wishlist.getCustomer().getId());
    }
}