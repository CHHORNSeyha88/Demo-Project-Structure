package com.spring.demo_project.model.user.response;

import com.spring.demo_project.model.role.response.RoleResponse;
import lombok.Data;

import java.time.Instant;

@Data
public class UserResponse {
    private String name;
    private String email;
    private String username;
    private String bio;
    private String avatar;
    private String address;
    private String phone;
    private RoleResponse roleResponse;
    private Instant createAt;
    private Instant updateAt;
}
