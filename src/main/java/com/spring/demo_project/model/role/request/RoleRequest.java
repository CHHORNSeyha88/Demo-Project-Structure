package com.spring.demo_project.model.role.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleRequest {
    private String name;
    private String code;
    private List<Long> permissionId = new ArrayList<>();
}
