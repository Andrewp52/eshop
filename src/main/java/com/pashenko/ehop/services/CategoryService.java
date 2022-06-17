package com.pashenko.ehop.services;

import com.pashenko.ehop.entities.dto.CategoryDto;
import com.pashenko.ehop.entities.productdata.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    Category addNewCategory(CategoryDto dto);
    List<Category> getRootCategories();
}
