package com.pashenko.ehop.entities.productdata;

import com.pashenko.ehop.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parameters")
@Data
public class ProductParameter extends BaseEntity {
    @Column(name = "parameter_name")
    private String name;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private ParamType parameterType;
    @Column(name = "value")
    private String value;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_parameters",
            joinColumns = @JoinColumn(name = "parameter_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
