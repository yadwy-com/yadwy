package com.yadwy.yadwy.cart;

import com.yadwy.yadwy.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

//    @PostMapping("/{cartId}/products/{productId}/quantity/{quantity}")
//    public CartDto addItemToCart(
//            @PathVariable Long cartId,
//            @PathVariable Long productId,
//            @PathVariable Integer quantity) {
//        return cartService.addItemToCart(cartId, productId,quantity);
//    }

    @GetMapping("/{customerId}/items")
    public List<CartItem> getCustomerCartItems(@PathVariable Long customerId) {
        return cartService.getCustomerCartItems(customerId);
    }
}
