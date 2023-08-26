package com.yadwy.yadwy.dto;

public record AddressDto(
        String street,
        String buildingName,
        String city,
        String state,
        String country,
        String pincode) {
}
