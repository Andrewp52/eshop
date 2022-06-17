package com.pashenko.ehop.entities.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryTreeDto extends CategoryDto {
    private List<CategoryTreeDto> children;

    public CategoryTreeDto(Long id, String name, String description, Long parentId, List<CategoryTreeDto> children) {
        super(id, name, description, parentId);
        this.children = children;
    }
}
