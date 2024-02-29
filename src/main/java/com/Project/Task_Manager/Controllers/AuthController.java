package com.Project.Task_Manager.Controllers;

import DTO.JwtRequest;
import DTO.JwtResponse;
import com.Project.Task_Manager.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    JwtResponse jwtResponse;
    @Autowired
    AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) throws Exception {
        return ResponseEntity.ok(authService.login(jwtRequest));
    }
}
