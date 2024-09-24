package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permisson")
public class PermissionEntity extends BaseEntity {
    @Column(name = "permisson_name")
    private String name;
    @Column(name = "module")
    private String module;
    @Column(name="permisson_code")
    private String code;

    @ManyToMany(mappedBy = "permissions")
    private List<RoleEntity> roles=new ArrayList<>();

}
