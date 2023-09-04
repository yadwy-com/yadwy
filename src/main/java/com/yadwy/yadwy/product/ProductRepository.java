package com.yadwy.yadwy.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long categoryId);

    @Query(value = "SELECT * FROM products ORDER BY RANDOM() LIMIT 4", nativeQuery = true)
    List<Product> findTopFourProducts();

    @Query(value = "SELECT * FROM products ORDER BY RANDOM() LIMIT 6", nativeQuery = true)
    List<Product> findTopNewProducts();

}
