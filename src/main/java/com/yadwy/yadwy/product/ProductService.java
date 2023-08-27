package com.yadwy.yadwy.product;

import com.yadwy.yadwy.category.CategoryRepository;
import com.yadwy.yadwy.dto.HomeProductDto;
import com.yadwy.yadwy.dto.ProductDto;
import com.yadwy.yadwy.exception.ResourceNotFoundException;
import com.yadwy.yadwy.review.Review;
import com.yadwy.yadwy.review.ReviewRepository;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    List<Product>getAllProducts(){
        return productRepository.findAll();
    }

    Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    public Product createProduct(ProductDto productDto) {
        var product = new Product();

        var category = categoryRepository.findById(productDto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", productDto.categoryId()));

        var vendor = userRepository.findById(productDto.vendorId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "vendorId", productDto.vendorId()));

        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setImage(productDto.image());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());
        product.setCreatedAt(productDto.createdAt());
        product.setUpdatedAt(productDto.updatedAt());
        product.setCategory(category);
        product.setVendor(vendor);
        log.info("product created successfully");

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        var category = categoryRepository.findById(productDto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", productDto.categoryId()));

        var vendor = userRepository.findById(productDto.vendorId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "vendorId", productDto.vendorId()));

        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setImage(productDto.image());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());
        product.setCreatedAt(productDto.createdAt());
        product.setUpdatedAt(productDto.updatedAt());
        product.setCategory(category);
        product.setVendor(vendor);
        log.info("product updated successfully");

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
        log.info("product deleted successfully , product id {}", product.getId());
    }

    public List<HomeProductDto> getHomeProducts() {
        return productRepository.findAll().stream()
                .map(product -> {
                    return new HomeProductDto(product.getId(), product.getName(), product.getImage(), product.getPrice());
                })
                .toList();
    }
}
