package com.vivek.shcms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class DoctorResponse {
        private Long id;
        private String name;
        private String specialization;
        private String hospital;
    }