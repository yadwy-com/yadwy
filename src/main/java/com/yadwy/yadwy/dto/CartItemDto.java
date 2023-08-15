package com.yadwy.yadwy.dto;

public record CartItemDto(
        Integer quantity,
        double discount,
        double productPrice
) {
}
