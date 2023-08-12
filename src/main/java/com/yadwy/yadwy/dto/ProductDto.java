package com.yadwy.yadwy.dto;

import java.time.LocalDate;

public record ProductDto(
        String name,
        String description,
        String image,
        Double price,
        Integer quantity,
        LocalDate createdAt,
        LocalDate updatedAt,
        Long categoryId) {
}
