package com.spring.demo_project.model.permisson.Request;

import lombok.Data;

import java.time.Instant;

@Data
public class PermissonRequest {
    private String name;
    private String module;
    private String code;
    private Instant createAt;
    private Instant updateAt;
}
