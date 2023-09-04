package com.yadwy.yadwy.product;


import com.yadwy.yadwy.dto.ProductInfoDto;
import com.yadwy.yadwy.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<Product> findAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/home")
    ResponseEntity<List<ProductInfoDto>> getHomeProducts() {
        return new ResponseEntity<>(productService.getHomeProducts(), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    ResponseEntity<List<ProductInfoDto>> getProductsByCategoryId(@PathVariable Long categoryId) {
        return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/top-products")
    ResponseEntity<List<ProductInfoDto>> getToFourProducts() {
        return new ResponseEntity<>(productService.getToFourProducts(), HttpStatus.OK);
    }

    @GetMapping("/new-products")
    ResponseEntity<List<ProductInfoDto>> findTopNewProducts() {
        return new ResponseEntity<>(productService.findTopNewProducts(), HttpStatus.OK);
    }

    @PostMapping
    Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    Product updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
