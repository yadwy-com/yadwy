package com.yadwy.yadwy.dto;

import java.time.LocalDate;

public record ReviewDto(
        String comment,
        Integer rating,
        LocalDate createAt,
        Long productId,
        Long customerId
) {
}
