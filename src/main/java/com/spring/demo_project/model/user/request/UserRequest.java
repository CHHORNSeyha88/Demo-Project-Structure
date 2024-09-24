package com.spring.demo_project.model.user.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String username;
    private String bio;
    private String avatar;
    private String address;
    private String phone;
    private Long roleId;
}
