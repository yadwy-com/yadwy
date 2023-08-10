package com.yadwy.yadwy.utils;

import com.yadwy.yadwy.cart.Cart;
import com.yadwy.yadwy.cart.CartItem;
import com.yadwy.yadwy.cart.CartRepository;
import com.yadwy.yadwy.category.Category;
import com.yadwy.yadwy.category.CategoryRepository;
import com.yadwy.yadwy.order.Order;
import com.yadwy.yadwy.order.OrderRepository;
import com.yadwy.yadwy.product.Product;
import com.yadwy.yadwy.product.ProductRepository;
import com.yadwy.yadwy.review.Review;
import com.yadwy.yadwy.review.ReviewRepository;
import com.yadwy.yadwy.user.User;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
public class DataLoader {
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {


            orderRepository.save(new Order(
                    1L,
                    LocalDate.now(),
                    200.0,
                    "hassan",
                    "CairoEgypt",
                    "0123456789",
                    "h@gmail.com"));

            orderRepository.save(new Order(
                    2L,
                    LocalDate.now(),
                    300.0,
                    "hassan2",
                    "CairoEgypt2",
                    "01234567892",
                    "h2@gmail.com"));

            Cart cart = new Cart();

            CartItem cartItem1 = new CartItem();
            cartItem1.setQuantity(2);
            cartItem1.setCart(cart);

            CartItem cartItem2 = new CartItem();
            cartItem2.setQuantity(3);
            cartItem2.setCart(cart);

            cart.getCartItems().add(cartItem1);
            cart.getCartItems().add(cartItem2);

            cartRepository.save(cart);



            reviewRepository.save(new Review(1L, "hassan", "so good", 5, LocalDate.now()));
            reviewRepository.save(new Review(2L, "hassan", "so bad", 2, LocalDate.now()));


        };
    }
}
