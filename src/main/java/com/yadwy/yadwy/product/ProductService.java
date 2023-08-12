package com.yadwy.yadwy.product;

import com.yadwy.yadwy.category.CategoryRepository;
import com.yadwy.yadwy.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public Product createProduct(ProductDto productDto) {
        var product = new Product();

        var category = categoryRepository.findById(productDto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category does not exist with id: " + productDto.categoryId()));

        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setImage(productDto.image());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());
        product.setCreatedAt(productDto.createdAt());
        product.setUpdatedAt(productDto.updatedAt());
        product.setCategory(category);
        log.info("product created successfully , product id {}", product.getId());

        return productRepository.save(product);
    }
}
