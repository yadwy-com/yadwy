package com.yadwy.yadwy.user;

import com.yadwy.yadwy.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createCustomer(UserDto userDto) {
        var user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setRole(Role.CUSTOMER);
        return userRepository.save(user);
    }

    User createVendor(UserDto userDto) {
        var user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setRole(Role.VENDOR);
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
