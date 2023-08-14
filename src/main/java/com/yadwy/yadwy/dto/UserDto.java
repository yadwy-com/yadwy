package com.yadwy.yadwy.dto;


public record UserDto(
        String firstName,
        String lastName,
        String email
) {
    // private Set<Role> roles = new HashSet<>();
    //  private CartDTO cart;
}
