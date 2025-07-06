package com.vivek.shcms.controller;

import com.vivek.shcms.dto.AdminDashboardResponse;
import com.vivek.shcms.service.AdminService;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/admin")
    public class AdminController {

        private final AdminService adminService;

        public AdminController(AdminService adminService) {
            this.adminService = adminService;
        }

        @GetMapping("/dashboard")
        public AdminDashboardResponse getDashboard() {
            return adminService.getDashboardStats();
        }
    }
