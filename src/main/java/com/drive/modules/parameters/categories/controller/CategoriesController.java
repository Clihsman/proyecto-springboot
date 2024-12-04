package com.drive.modules.parameters.categories.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.parameters.categories.model.Category;
import com.drive.modules.parameters.categories.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/parameters/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/{categoryType}")
    public List<Category> getCategories(@PathVariable Category.CategoryType categoryType) {
        return categoryRepository.findAllByCategoryType(categoryType);
    }

}
