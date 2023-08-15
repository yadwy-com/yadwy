package com.yadwy.yadwy.cart;

import com.yadwy.yadwy.dto.CartItemDto;
import com.yadwy.yadwy.exception.ResourceNotFoundException;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public CartItem addItemToCart(Long customerId, CartItemDto cartItemDto) {
        var cart = cartRepository.findByCustomerId(customerId);
        var user = userRepository.findById(customerId).
                orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(user);
        }
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setQuantity(cartItemDto.quantity());
        cartItem.setDiscount(cartItemDto.discount());
        cartItem.setProductPrice(cartItemDto.productPrice());

        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCustomerCartItems(Long customerId) {
        var cart = cartRepository.findByCustomerId(customerId);

        if (cart == null) {
            throw new ResourceNotFoundException("Cart not found");
        }
        return cartItemRepository.findByCartId(cart.getId());
    }
}
