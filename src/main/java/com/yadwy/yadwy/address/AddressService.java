package com.yadwy.yadwy.address;

import com.yadwy.yadwy.exception.ResourceNotFoundException;
import com.yadwy.yadwy.user.User;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public User addAddressToUser(Long userId, Address address) {
        var user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        user.setAddress(address);
        addressRepository.save(address);
        return userRepository.save(user) ;
    }
}
