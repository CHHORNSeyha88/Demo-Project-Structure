package com.spring.demo_project.service;

import com.spring.demo_project.base.BaseService;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.entity.PermissionEntity;
import com.spring.demo_project.entity.RoleEntity;
import com.spring.demo_project.model.role.Mapper.RoleMapper;
import com.spring.demo_project.model.role.request.RoleRequest;
import com.spring.demo_project.model.role.response.RoleResponse;
import com.spring.demo_project.repository.PermissionEntityRepository;
import com.spring.demo_project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService extends BaseService {
    private final RoleRepository roleRepository;
    private final PermissionEntityRepository permissionEntityRepository;
    private final RoleMapper roleMapper;



    public StructureRS create(RoleRequest request) {
        // Create and populate RoleEntity from RoleRequest
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(request.getName());
        roleEntity.setCode(request.getCode());
        for(Long id: request.getPermissionId()) {
            PermissionEntity permissionEntity = permissionEntityRepository.findById(id).get();
            roleEntity.getPermissions().add(permissionEntity);
        }
        // Save RoleEntity to the repository
        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);

        // Map saved RoleEntity to RoleResponse
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setName(savedRoleEntity.getName());
        roleResponse.setCode(savedRoleEntity.getCode());
        roleResponse.setCreateAt(savedRoleEntity.getCreatedDate());
        roleResponse.setUpdateAt(savedRoleEntity.getModifiedDate());

        // Return response
        return response(HttpStatus.CREATED, "Role created successfully", roleResponse);
    }


    public StructureRS getAll() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<RoleResponse> roleResponses = roleEntities.stream().map(roleMapper::toRoleResponse).collect(Collectors.toList());

        return response(HttpStatus.OK, "Successful", roleResponses);
    }

    public StructureRS getById(Long id) {
        Optional<RoleEntity> roleEntities = roleRepository.findById(id);
        List<RoleResponse>  roleResponses = roleEntities.stream().map(roleEntity -> {
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setName(roleEntity.getName());
            roleResponse.setCode(roleEntity.getCode());
            roleResponse.setCreateAt(roleEntity.getCreatedDate());
            roleResponse.setUpdateAt(roleEntity.getModifiedDate());
            return roleResponse;
        }).collect(Collectors.toList());
        return response(HttpStatus.OK, "Successful", roleResponses);
    }

    public ResponseEntity<String> deleteById(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found");
        } else {
            roleRepository.deleteById(id);
            return ResponseEntity.ok("Role deleted with id = " + id);
        }
    }

    public StructureRS updateRoleById(Long id, RoleRequest request) {
        Optional<RoleEntity> roleEntities = roleRepository.findById(id);
        if (!roleEntities.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found");
        }
        RoleEntity roleEntity = roleEntities.get();
        //update
        roleEntity.setName(request.getName());
        roleEntity.setCode(request.getCode());
        //save update

        RoleEntity updatedRoleEntity = roleRepository.save(roleEntity);
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setName(updatedRoleEntity.getName());
        roleResponse.setCode(updatedRoleEntity.getCode());
        roleResponse.setUpdateAt(updatedRoleEntity.getCreatedDate());
        roleResponse.setUpdateAt(updatedRoleEntity.getModifiedDate());

       return response(HttpStatus.OK, "Successful", roleResponse);
//
    }

    public StructureRS findAllByQuery(String query) {
        RoleEntity roleEntities = roleRepository.findAllByQuery(query).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));

        return response(HttpStatus.OK, "Successful", roleMapper.toRoleResponse(roleEntities));
    }

    }


