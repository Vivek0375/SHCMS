package com.vivek.shcms.controller;

import com.vivek.shcms.dto.LoginRequest;
import com.vivek.shcms.dto.RegisterRequest;
import com.vivek.shcms.dto.AuthResponse;
import com.vivek.shcms.service.UserService;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {

        private final UserService userService;

        public AuthController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping("/register")
        public AuthResponse register(@RequestBody RegisterRequest request) {
            return userService.register(request);
        }

        @PostMapping("/login")
        public AuthResponse login(@RequestBody LoginRequest request) {
            return userService.login(request);
        }
    }

