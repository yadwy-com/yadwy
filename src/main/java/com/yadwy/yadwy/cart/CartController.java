package com.yadwy.yadwy.cart;

import com.yadwy.yadwy.dto.CartItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/{customerId}/items")
    public CartItem addItemToCart(@PathVariable Long customerId,@RequestBody CartItemDto cartItemDto){
        return cartService.addItemToCart(customerId, cartItemDto);
    }
    @GetMapping("/{customerId}/items")
    public List<CartItem> getCustomerCartItems(@PathVariable Long customerId){
        return cartService.getCustomerCartItems(customerId);
    }
}
