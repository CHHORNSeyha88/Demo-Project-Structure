package com.spring.demo_project.model.permisson.Mapper;

import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.model.permisson.Response.PermissionResponse;
import org.mapstruct.Mapper;

import java.security.Permission;

@Mapper
public interface PermissionMapper {
    PermissionResponse toResponse(PermissionEntity permissionEntity);

}
