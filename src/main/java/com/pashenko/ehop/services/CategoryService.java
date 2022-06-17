package com.pashenko.ehop.services;

import com.pashenko.ehop.entities.dto.CategoryRegDto;
import com.pashenko.ehop.entities.productdata.Category;

public interface CategoryService {
    Category getCategoryById(Long id);
    Category addNewCategory(CategoryRegDto dto);
}
