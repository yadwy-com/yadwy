package com.yadwy.yadwy.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @GetMapping
    List<Category>findAll(){
        return List.of(
                new Category(1L,"name","description","image"),
                new Category(2L,"name2","description2","image2")
        );
    }

}
