package com.yadwy.yadwy.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    List<Category>getAllCategories(){
        return categoryRepository.findAll();
    }

    Category createCategory(Category category) {
        log.info("category created");
        return categoryRepository.save(category);
    }

}
