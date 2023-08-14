package com.yadwy.yadwy.review;

import com.yadwy.yadwy.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    List<Review> findAll() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/{id}")
    Review createReview(@PathVariable Long id,@RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(id,reviewDto);
    }
}
