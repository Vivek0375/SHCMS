package com.vivek.shcms.dto;

import lombok.Data;

    @Data
    public class DoctorRequest {
        private String name;
        private String email;
        private String specialization;
        private int experienceYears;
        private String hospital;
        private String contact;
    }