package com.pashenko.ehop.entities.userdata;

import com.pashenko.ehop.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class UserAddress extends BaseEntity {
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;

}
