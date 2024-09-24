package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.permisson.Request.PermissonRequest;
import com.spring.demo_project.repository.PermissionEntityRepository;
import com.spring.demo_project.service.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/permission")
public class PermissionController extends BaseController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @PostMapping
    public ResponseEntity<StructureRS> addPermission(@RequestBody PermissonRequest permissonRequest) {
        return response(permissionService.addPermission(permissonRequest));
    }
}
