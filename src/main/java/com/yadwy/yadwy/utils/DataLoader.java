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
//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//
//        };
//    }
}
