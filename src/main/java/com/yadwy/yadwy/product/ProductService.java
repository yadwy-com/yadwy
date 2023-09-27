package com.yadwy.yadwy.product;

import com.yadwy.yadwy.category.CategoryRepository;
import com.yadwy.yadwy.dto.ProductInfoDto;
import com.yadwy.yadwy.dto.ProductDto;
import com.yadwy.yadwy.exception.ResourceNotFoundException;
import com.yadwy.yadwy.review.ReviewRepository;
import com.yadwy.yadwy.s3.S3Service;
import com.yadwy.yadwy.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final S3Service s3Service;
    @Value("${aws.s3.bucket}")
    private String bucketName;

    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    public List<ProductInfoDto> getHomeProducts() {
        return productRepository.findAll().stream()
                .map(product -> {
                    return new ProductInfoDto(product.getId(), product.getName(), product.getImage(), product.getPrice());
                })
                .toList();
    }

    public List<ProductInfoDto> getProductsByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream().map(product ->
                new ProductInfoDto(product.getId(), product.getName(), product.getImage(), product.getPrice())
        ).toList();
    }

    public Product createProduct(
            String name,
            String description,
            MultipartFile imageUrl,
            Double price,
            Integer quantity,
            LocalDate createdAt,
            LocalDate updatedAt,
            Long categoryId,
            Long vendorId
    ) throws IOException {
        var product = new Product();
        var category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        var vendor = userRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "vendorId", vendorId));

        String productImageId = UUID.randomUUID().toString();
        var url = s3Service.putObject(
                bucketName,
                productImageId,
                imageUrl.getBytes()
        );

        product.setName(name);
        product.setDescription(description);
        product.setImage(url);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCreatedAt(createdAt);
        product.setUpdatedAt(updatedAt);
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
        //product.setImage(productDto.image());
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


    public List<ProductInfoDto> getToFourProducts() {
        return productRepository.findTopFourProducts().stream()
                .map(product -> new ProductInfoDto(product.getId(), product.getName(), product.getImage(), product.getPrice()))
                .toList();
    }

    public List<ProductInfoDto> findTopNewProducts() {
        return productRepository.findTopFourProducts().stream()
                .map(product -> new ProductInfoDto(product.getId(), product.getName(), product.getImage(), product.getPrice()))
                .toList();
    }

}
