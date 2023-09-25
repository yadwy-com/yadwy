package com.yadwy.yadwy.category;

import com.yadwy.yadwy.exception.ResourceNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    Category createCategory(Category category) {
        log.info("category created");
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {

        val category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new ResourceNotFoundException("Category with id: " + id + " not found");
        }

        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Long id,Category category) {
        val categoryToUpdate = categoryRepository.findById(id);

        if (categoryToUpdate.isEmpty()) {
            throw new ResourceNotFoundException("Category with id: " + category.getId() + " not found");
        }

        return categoryRepository.save(category);
    }
}
