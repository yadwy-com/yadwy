package com.yadwy.yadwy.product;


import com.yadwy.yadwy.dto.ProductInfoDto;
import com.yadwy.yadwy.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
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
    @ResponseStatus(HttpStatus.CREATED)
    Product createProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("imageUrl") MultipartFile imageUrl,
            @RequestParam("price") Double price,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("createdAt") LocalDate createdAt,
            @RequestParam("updatedAt") LocalDate updatedAt,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("vendorId") Long vendorId
    ) throws IOException {
        return productService.createProduct(name, description, imageUrl, price, quantity, createdAt, updatedAt, categoryId, vendorId);
    }

    @PutMapping("/{id}")
    Product updateProduct(@PathVariable Long id, @RequestPart ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
