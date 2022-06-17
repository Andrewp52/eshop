package com.pashenko.ehop.entities.productdata;

import com.pashenko.ehop.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "images")
public class ProductImage extends BaseEntity {
    @Column(name = "image_url")
    private String url;
    @Column(name = "description")
    private String description;

}
