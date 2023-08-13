package com.yadwy.yadwy.product;

import com.yadwy.yadwy.category.CategoryRepository;
import com.yadwy.yadwy.dto.ProductDto;
import com.yadwy.yadwy.exception.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", productDto.categoryId()));

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

    public Product updateProduct(Long id, ProductDto productDto) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        var category = categoryRepository.findById(productDto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", productDto.categoryId()));

        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setImage(productDto.image());
        product.setPrice(productDto.price());
        product.setQuantity(productDto.quantity());
        product.setCreatedAt(productDto.createdAt());
        product.setUpdatedAt(productDto.updatedAt());
        product.setCategory(category);
        log.info("product updated successfully , product id {}", product.getId());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        productRepository.delete(product);
        log.info("product deleted successfully , product id {}", product.getId());
    }
}
