package com.yadwy.yadwy.review;

import com.yadwy.yadwy.dto.ReviewDto;
import com.yadwy.yadwy.exception.ResourceNotFoundException;
import com.yadwy.yadwy.product.ProductRepository;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Review createReview(Long userID, ReviewDto reviewDto) {

        var product = productRepository.findById(reviewDto.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", reviewDto.productId()));

        var customer = userRepository.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userID));
        var review = new Review();
        review.setComment(reviewDto.comment());
        review.setRating(reviewDto.rating());
        review.setCreateAt(reviewDto.createAt());
        review.setProduct(product);
        review.setCustomer(customer);
        product.setReview(review);
        log.info("review created successfully");
        return reviewRepository.save(review);
    }


    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
