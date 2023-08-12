package com.yadwy.yadwy.product;


import com.yadwy.yadwy.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;
    @GetMapping
    List<Product> findAll() {
        return productRepository.findAll();
    }

    @PostMapping
    Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
}
