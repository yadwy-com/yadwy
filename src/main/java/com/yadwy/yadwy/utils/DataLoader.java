package com.yadwy.yadwy.utils;

import com.yadwy.yadwy.cart.Cart;
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
            categoryRepository.save(new Category(1L, "test", "test", "test.png"));
            categoryRepository.save(new Category(2L, "test2", "test2", "test2.png"));

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

            cartRepository.save(new Cart(1L));
            cartRepository.save(new Cart(2L));

            productRepository.save(new Product(
                    1L,
                    "test",
                    "test",
                    "test.png",
                    232.0,
                    23,
                    LocalDate.now(),
                    LocalDate.now()));

            productRepository.save(new Product(
                    2L,
                    "test2",
                    "test2",
                    "test2.png",
                    23.0,
                    10,
                    LocalDate.now(),
                    LocalDate.now()));

            reviewRepository.save(new Review(1L, "hassan", "so good", 5, LocalDate.now()));
            reviewRepository.save(new Review(2L, "hassan", "so bad", 2, LocalDate.now()));

            userRepository.save(new User(1L, "hassan", "refaat","h@gmail.com"));
            userRepository.save(new User(2L, "Abdo", "Ali","abdo@gmail.com"));

        };
    }
}
