package com.pashenko.ehop.controllers;

import com.pashenko.ehop.entities.dto.CategoryRegDto;
import com.pashenko.ehop.entities.productdata.Category;
import com.pashenko.ehop.services.CategoryService;
import com.pashenko.ehop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/catalog")
@RequiredArgsConstructor
public class CatalogAdminController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/categories")
    private String getCategoriesTreesList(Model model){
        return "categories-admin";
    }

    @GetMapping("/categories/{id}")
    private String getEditCategoryForm(@PathVariable(name = "id") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("categoryRegDto", CategoryRegDto.fromEntity(category));
        return "category-edit-form";
    }

    @GetMapping("/categories/add")
    private String getCategoryAddForm(Model model){
        model.addAttribute("categoryRegDto", new CategoryRegDto());
        return "category-add-form";
    }

    @PostMapping("/categories")
    private String addNewCategory(@ModelAttribute @Valid CategoryRegDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("categoryRegDto", dto);
            return "category-add-form";
        }
        Category added = categoryService.addNewCategory(dto);
        return "/admin/catalog/categories/edit/" + added.getId();
    }
}
