package com.spring.demo_project.model.role.response;

import com.spring.demo_project.model.permisson.Response.PermissionResponse;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
public class RoleResponse {
    private String id;
    private String name;
    private String code;
    private String module;
    private Set<PermissionResponse> permissions = new HashSet<>();
    private Instant createAt;
    private Instant updateAt;
}
