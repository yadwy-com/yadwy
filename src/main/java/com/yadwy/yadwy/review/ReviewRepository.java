package com.yadwy.yadwy.review;

import com.yadwy.yadwy.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
