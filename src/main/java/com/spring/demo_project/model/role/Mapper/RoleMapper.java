package com.spring.demo_project.model.role.Mapper;

import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.model.role.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoleMapper {
    @Mapping(target = "createAt",source = "createdDate")
    @Mapping(target = "updateAt",source = "modifiedDate")
    RoleResponse toRoleResponse(RoleEntity roleEntity);

}
