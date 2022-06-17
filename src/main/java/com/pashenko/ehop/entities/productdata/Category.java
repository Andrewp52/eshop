package com.pashenko.ehop.entities.productdata;

import com.pashenko.ehop.entities.BaseEntity;
import com.pashenko.ehop.entities.dto.CategoryDto;
import com.pashenko.ehop.entities.dto.CategoryTreeDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(name = "category_name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "categories_products",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public CategoryDto toSimpleDto(){
        return new CategoryDto(this.getId(), this.name, this.description, this.parent.getId());
    }

    public CategoryTreeDto toTreeDto(){
        return new CategoryTreeDto(
          this.getId(),
          this.name,
          this.description,
          this.parent == null ? null : this.parent.getId(),
          this.children.stream().map(Category::toTreeDto).collect(Collectors.toList())
        );
    }
}
