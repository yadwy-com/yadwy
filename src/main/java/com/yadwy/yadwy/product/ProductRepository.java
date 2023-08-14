package com.yadwy.yadwy.product;

import com.yadwy.yadwy.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
