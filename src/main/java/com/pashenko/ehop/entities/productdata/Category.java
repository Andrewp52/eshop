package com.pashenko.ehop.entities.productdata;

import com.pashenko.ehop.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Category> children;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "categories_products",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
