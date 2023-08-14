package com.yadwy.yadwy.user;

import com.yadwy.yadwy.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/customers")
    User createCustomer(@RequestBody UserDto userDto) {
        return userService.createCustomer(userDto);
    }

    @PostMapping("/vendors")
    User createVendor(@RequestBody UserDto userDto) {
        return userService.createVendor(userDto);
    }
}
