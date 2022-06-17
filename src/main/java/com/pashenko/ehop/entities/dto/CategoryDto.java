package com.pashenko.ehop.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Long parentId;

}
