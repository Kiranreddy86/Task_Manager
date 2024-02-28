package com.Project.Task_Manager.Controllers;

import DTO.UserRequest;
import com.Project.Task_Manager.Entity.UserEntity;
import com.Project.Task_Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserEntity userEntity){
        userService.register(userEntity);
    }
}
