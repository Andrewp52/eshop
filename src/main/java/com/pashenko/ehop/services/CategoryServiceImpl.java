package com.pashenko.ehop.services;

import com.pashenko.ehop.entities.dto.CategoryRegDto;
import com.pashenko.ehop.entities.productdata.Category;
import com.pashenko.ehop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
    public Category addNewCategory(CategoryRegDto dto) {
        return null;
    }
}
