package com.yadwy.yadwy.address;

import com.yadwy.yadwy.dto.AddressDto;
import com.yadwy.yadwy.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    @PostMapping("/users/{userId}/addresses")
    User createAddress(@PathVariable Long userId, @RequestBody Address address) {
        return  addressService.addAddressToUser(userId,address);
    }
}
