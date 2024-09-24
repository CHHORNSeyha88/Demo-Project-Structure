package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.model.permisson.Mapper.PermissionMapper;
import com.spring.demo_project.model.permisson.Request.PermissonRequest;
import com.spring.demo_project.model.permisson.Response.PermissionResponse;
import com.spring.demo_project.repository.PermissionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionService extends BaseService {
    private final PermissionEntityRepository permissionEntityRepository;
    private final PermissionMapper permissionMapper;

    public StructureRS addPermission(PermissonRequest permissonRequest) {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setName(permissonRequest.getName());
        permissionEntity.setModule(permissonRequest.getModule());
        permissionEntity.setCode(permissonRequest.getCode());

        permissionEntityRepository.save(permissionEntity);


        return response(HttpStatus.CREATED,"CreateSuccessful",permissionMapper.toResponse(permissionEntity));
    }
}
