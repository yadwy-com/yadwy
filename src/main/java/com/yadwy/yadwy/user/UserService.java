package com.yadwy.yadwy.user;

import com.yadwy.yadwy.cart.Cart;
import com.yadwy.yadwy.cart.CartRepository;
import com.yadwy.yadwy.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CartRepository  cartRepository;

    public User createCustomer(UserDto userDto) {
        var user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setRole(Role.CUSTOMER);
        var savedUser = userRepository.save(user);

        var cart = new Cart();
        cart.setCustomer(savedUser);

        savedUser.setCart(cart);
        cartRepository.save(cart);


        return savedUser;
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
