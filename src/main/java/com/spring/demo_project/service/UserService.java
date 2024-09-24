package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.entity.UserEntity;
import com.spring.demo_project.model.permisson.Response.PermissionResponse;
import com.spring.demo_project.model.role.response.RoleResponse;
import com.spring.demo_project.model.user.Mapper.UserMapper;
import com.spring.demo_project.model.user.request.UserRequest;
import com.spring.demo_project.model.user.response.UserResponse;
import com.spring.demo_project.repository.RoleRepository;
import com.spring.demo_project.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService {
    private final UserEntityRepository userEntityRepository;
    private final RoleRepository  roleRepository;
    private final UserMapper userMapper;

    public StructureRS createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setAddress(userRequest.getAddress());
        userEntity.setBio(userRequest.getBio());
        userEntity.setPhone(userRequest.getPhone());
        userEntity.setAvatar(userRequest.getAvatar());
        RoleEntity role = roleRepository.findById(userRequest.getRoleId()).get();
        userEntity.setRole(role);

        UserEntity saveuserEntity = userEntityRepository.save(userEntity);

        UserResponse userResponse = new UserResponse();
        userResponse.setName(saveuserEntity.getName());
        userResponse.setEmail(saveuserEntity.getEmail());
        userResponse.setUsername(saveuserEntity.getUsername());
        userResponse.setAddress(saveuserEntity.getAddress());
        userResponse.setBio(saveuserEntity.getBio());
        userResponse.setPhone(saveuserEntity.getPhone());
        userResponse.setAvatar(saveuserEntity.getAvatar());
        userResponse.setCreateAt(saveuserEntity.getCreatedDate());
        userResponse.setUpdateAt(saveuserEntity.getModifiedDate());

        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setName(saveuserEntity.getRole().getName());
        roleResponse.setCode(saveuserEntity.getRole().getCode());
        roleResponse.setModule(saveuserEntity.getRole().getModule());
        Set<PermissionResponse> permissionResponses = new HashSet<>();


        for (PermissionEntity permission: saveuserEntity.getRole().getPermissions()){
            PermissionResponse permissionResponse = new PermissionResponse();
            permissionResponse.setName(permission.getName());
            permissionResponse.setCode(permission.getCode());
            permissionResponse.setModule(permission.getModule());
            permissionResponses.add(permissionResponse);
        }
        roleResponse.setPermissions(permissionResponses);
        userResponse.setRoleResponse(roleResponse);

        return response(HttpStatus.CREATED,"CreateSuccessful",userResponse);
    }

    public StructureRS getAll() {
        return response(HttpStatus.OK,"GetAllSuccessful",userEntityRepository.getAll());
    }
    @Transactional(readOnly = true)
    public StructureRS getList(){
        List<UserEntity> user = userEntityRepository.getAll();
        return response(user.stream().map(userMapper::userToUserResponse));
    }




}
