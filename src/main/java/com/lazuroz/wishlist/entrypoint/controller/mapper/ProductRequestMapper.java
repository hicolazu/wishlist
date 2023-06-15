package com.lazuroz.wishlist.entrypoint.controller.mapper;

import com.lazuroz.wishlist.core.domain.Product;
import com.lazuroz.wishlist.entrypoint.controller.request.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    Product toProduct(ProductRequest productRequest);
}
