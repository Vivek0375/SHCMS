package com.vivek.shcms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

    @Data
    @AllArgsConstructor
    public class AdminDashboardResponse {
        private long totalUsers;
        private long totalPatients;
        private long totalDoctors;
        private long totalAppointments;
        private long totalMedicalRecords;
        private List<String> topDoctors;
    }


