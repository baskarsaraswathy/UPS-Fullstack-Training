package com.shop.ecommerce.dto;

public record UserResponse(
        Long id,
        String fullName,
        String email
) {
}