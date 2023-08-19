package com.yadwy.yadwy.cart;

import com.yadwy.yadwy.dto.CartDto;
import com.yadwy.yadwy.dto.CartItemDto;
import com.yadwy.yadwy.dto.ProductDto;
import com.yadwy.yadwy.exception.ApiException;
import com.yadwy.yadwy.exception.ResourceNotFoundException;
import com.yadwy.yadwy.product.ProductRepository;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartDto addItemToCart(Long cartId, Long productId,Integer quantity) {


        var c = new Cart();
        cartRepository.save(c);

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart", "cartId", cartId));

        var product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        var  cartItem = cartItemRepository.findCartItemByProductIdAndCartId(cartId, productId);

        if (cartItem != null) {
            throw new ApiException("Product " + product.getName() + " already exists in the cart");
        }

        if (product.getQuantity() == 0) {
            throw new ApiException(product.getName() + " is not available");
        }

        if (product.getQuantity() < quantity) {
            throw new ApiException("Please, make an order of the " + product.getName()
                    + " less than or equal to the quantity " + product.getQuantity() + ".");
        }

        CartItem newCartItem = new CartItem();

        newCartItem.setProduct(product);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(quantity);
        newCartItem.setProductPrice(product.getPrice());
        cartItemRepository.save(newCartItem);

        product.setQuantity(product.getQuantity() - quantity);
        cart.setTotalPrice(cart.getTotalPrice() + (product.getPrice() * quantity));

        var cartDto = new CartDto();
        cartDto.setCartId(cartId);
        cartDto.setTotalPrice(product.getPrice());

        List<ProductDto> productDTOs = cart.getCartItems().stream()
                .map(item -> new ProductDto(
                        item.getProduct().getName(),
                        item.getProduct().getDescription(),
                        item.getProduct().getImage(),
                        item.getProduct().getPrice(),
                        item.getProduct().getQuantity(),
                        item.getProduct().getCreatedAt(),
                        item.getProduct().getUpdatedAt(),
                        item.getProduct().getCategory().getId(),
                        item.getProduct().getVendor().getId()
                )).toList();

        cartDto.setProducts(productDTOs);
        return cartDto;
    }

    public List<CartItem> getCustomerCartItems(Long customerId) {
        var cart = cartRepository.findByCustomerId(customerId);

        if (cart == null) {
            throw new ResourceNotFoundException("Cart not found");
        }
        return cartItemRepository.findByCartId(cart.getId());
    }
}
