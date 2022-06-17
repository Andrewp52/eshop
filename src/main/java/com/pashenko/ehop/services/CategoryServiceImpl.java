package com.pashenko.ehop.services;

import com.pashenko.ehop.entities.dto.CategoryDto;
import com.pashenko.ehop.entities.productdata.Category;
import com.pashenko.ehop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Category not found")
        );
    }

    @Override
    public Category addNewCategory(CategoryDto dto) {
        return null;
    }

    @Override
    public List<Category> getRootCategories() {
        return categoryRepository.getAllByParentIsNull().orElseGet(Collections::emptyList);
    }
}
