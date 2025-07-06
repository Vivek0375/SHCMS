package com.vivek.shcms.service;

import com.vivek.shcms.dto.LoginRequest;
import com.vivek.shcms.dto.RegisterRequest;
import com.vivek.shcms.dto.AuthResponse;
import com.vivek.shcms.model.User;
import com.vivek.shcms.repository.UserRepository;
import com.vivek.shcms.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class UserService {

        private final UserRepository userRepository;
        private final JwtUtil jwtUtil;
        private final PasswordEncoder passwordEncoder;

        public UserService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.jwtUtil = jwtUtil;
            this.passwordEncoder = passwordEncoder;
        }

        public AuthResponse register(RegisterRequest request) {
            User user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .build();
            userRepository.save(user);
            return new AuthResponse(jwtUtil.generateToken(user.getEmail()));
        }

        public AuthResponse login(LoginRequest request) {
            Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
            if (userOpt.isEmpty()) throw new RuntimeException("User not found");
            User user = userOpt.get();
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid credentials");
            }
            return new AuthResponse(jwtUtil.generateToken(user.getEmail()));
        }
    }

