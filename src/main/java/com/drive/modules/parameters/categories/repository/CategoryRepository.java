package com.drive.modules.parameters.categories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.parameters.categories.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByCategoryType(Category.CategoryType  categoryType);
}
