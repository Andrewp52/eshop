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
@Table(name = "phones")
public class UserPhone extends BaseEntity {
    @Column(name = "phone")
    private String phone;
    @Column(name = "description")
    private String description;
}
