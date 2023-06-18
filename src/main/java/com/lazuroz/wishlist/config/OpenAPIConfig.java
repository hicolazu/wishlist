package com.lazuroz.wishlist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenAPIConfig {

    @Value("${swagger.openapi.dev-url}")
    private String devUrl;

    @Value("${swagger.openapi.email}")
    private String email;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setName("Henrico Lazuroz");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Wishlist API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage wishilists.")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(Collections.singletonList(devServer));
    }
}
