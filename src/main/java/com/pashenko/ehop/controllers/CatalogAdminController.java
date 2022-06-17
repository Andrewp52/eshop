package com.pashenko.ehop.controllers;

import com.pashenko.ehop.entities.dto.CategoryDto;
import com.pashenko.ehop.entities.dto.CategoryTreeDto;
import com.pashenko.ehop.entities.productdata.Category;
import com.pashenko.ehop.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/catalog")
@RequiredArgsConstructor
public class CatalogAdminController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    private String getCategoriesTreesList(Model model){
        return "categories-admin";
    }

    @GetMapping("/categories/{id}")
    private String getEditCategoryForm(@PathVariable(name = "id") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("categoryRegDto", category.toSimpleDto());
        return "category-edit-form";
    }

    @GetMapping("/categories/add")
    private String getCategoryAddForm(Model model){
        List<Category> existing = categoryService.getRootCategories();
        List<CategoryTreeDto> parents = existing.stream().map(Category::toTreeDto).collect(Collectors.toList());
        model.addAttribute("parents", parents);
        model.addAttribute("categoryRegDto", new CategoryDto());
        return "category-add-form";
    }

    @PostMapping("/categories")
    private String addNewCategory(@ModelAttribute @Valid CategoryDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("categoryRegDto", dto);
            return "category-add-form";
        }
        Category added = categoryService.addNewCategory(dto);
        return "/admin/catalog/categories/edit/" + added.getId();
    }
}
