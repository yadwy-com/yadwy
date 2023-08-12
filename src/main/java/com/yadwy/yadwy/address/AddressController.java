package com.yadwy.yadwy.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressRepository addressRepository;
    @PostMapping
    Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }
}
