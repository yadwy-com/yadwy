package com.yadwy.yadwy.dto;

public record UserDTO(
        String firstName,
        String lastName,
        String email,
        AddressDTO address
) {
    // private Set<Role> roles = new HashSet<>();
    //  private CartDTO cart;
}
