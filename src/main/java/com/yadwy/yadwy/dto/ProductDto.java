package com.yadwy.yadwy.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record ProductDto(
        String name,
        String description,
        MultipartFile imageUrl,
        Double price,
        Integer quantity,
        LocalDate createdAt,
        LocalDate updatedAt,
        Long categoryId,
        Long vendorId
) {
}
