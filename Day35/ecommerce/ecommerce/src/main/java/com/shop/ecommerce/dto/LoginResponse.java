package com.shop.ecommerce.dto;

public record LoginResponse(
        String token,
        Long id,
        String fullName,
        String email
) {
}