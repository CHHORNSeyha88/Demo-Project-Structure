package com.spring.demo_project.entity;

import com.spring.demo_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @Column(name = "bio")
    private String bio;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "role_id"
    )
    private RoleEntity role;
}
