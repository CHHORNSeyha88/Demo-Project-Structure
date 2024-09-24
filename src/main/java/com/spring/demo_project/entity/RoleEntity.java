package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "role")
public class RoleEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    private String module;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_has_permisson",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id")

    )
    private List<PermissionEntity> permissions = new ArrayList<>();

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users = new ArrayList<>();

}
