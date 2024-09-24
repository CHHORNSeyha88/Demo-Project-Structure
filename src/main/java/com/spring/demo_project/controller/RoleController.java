package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.role.request.RoleRequest;
import com.spring.demo_project.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController extends BaseController {
    private final RoleService roleService;


    @PostMapping
    public ResponseEntity<StructureRS> create(@RequestBody RoleRequest request) {
        return response(roleService.create(request));
    }
    @GetMapping("/all")
    public ResponseEntity<StructureRS> getAll() {
        return response(roleService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StructureRS> getById(@PathVariable Long id) {
        return response(roleService.getById(id));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StructureRS> deleteById(@PathVariable Long id) {
        return response(roleService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureRS> update(@PathVariable Long id, @RequestBody RoleRequest request) {
        StructureRS response = roleService.updateRoleById(id, request);
        return ResponseEntity.ok(response); // Returns 200 OK with the response body
    }
    @GetMapping("/data")
    public ResponseEntity<StructureRS> findAllByQuery(@RequestParam String query) {
        return response(roleService.findAllByQuery(query));
    }

}
