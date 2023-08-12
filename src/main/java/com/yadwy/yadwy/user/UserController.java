package com.yadwy.yadwy.user;

import com.yadwy.yadwy.address.Address;
import com.yadwy.yadwy.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    UserDTO createUser(@RequestBody UserDTO userDto) {
        var user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        var addressDto = userDto.address();

        var address = new Address();
        address.setStreet(addressDto.street());
        address.setBuildingName(addressDto.buildingName());
        address.setCity(addressDto.city());
        address.setState(addressDto.state());
        address.setCountry(addressDto.country());
        address.setPincode(addressDto.pincode());

        var addressesList = new ArrayList<Address>();
        addressesList.add(address);

        user.setAddresses(addressesList);
        userRepository.save(user);

        return userDto;
    }
}
