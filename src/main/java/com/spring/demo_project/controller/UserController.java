package com.spring.demo_project.controller;

import com.spring.demo_project.base.BaseController;
import com.spring.demo_project.base.StructureRS;
import com.spring.demo_project.model.user.request.UserRequest;
import com.spring.demo_project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
   public ResponseEntity<StructureRS> createUser(@RequestBody UserRequest userRequest) {
        return response(userService.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<StructureRS> getAll() {
        return response(userService.getList());
    }

}
