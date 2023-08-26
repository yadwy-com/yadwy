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

    @GetMapping("/customers")
    List<User> getAllCustomers() {
        return userService.getAllCustomers();
    }
    @GetMapping("/{id}")
    User getById(@PathVariable Long id) {
        return userService.getUserById(id);
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
