package com.spring.demo_project.model.user.Mapper;

import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.model.role.response.RoleResponse;
import com.spring.demo_project.model.user.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(source = "createdDate",target = "createAt")
    @Mapping(source = "modifiedDate",target = "updateAt")
    @Mapping(target = "roleResponse", source = "role")
    UserResponse userToUserResponse(UserEntity user);
    //if roleResponse so we to declear this
//    RoleResponse from(RoleEntity role);
}
