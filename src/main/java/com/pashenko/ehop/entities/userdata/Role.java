package com.pashenko.ehop.entities.userdata;

import com.pashenko.ehop.entities.BaseEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {
    @Column(name = "role_name")
    private String name;
    @Column(name = "description")
    private String description;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
