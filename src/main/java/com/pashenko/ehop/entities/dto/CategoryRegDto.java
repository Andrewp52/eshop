package com.pashenko.ehop.entities.dto;

import com.pashenko.ehop.entities.productdata.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRegDto {
    private String name;
    private String description;
    private Long parentId;

    public static CategoryRegDto fromEntity(Category category){
        return new CategoryRegDto(category.getName(), category.getDescription(), category.getParent().getId());
    }
}
