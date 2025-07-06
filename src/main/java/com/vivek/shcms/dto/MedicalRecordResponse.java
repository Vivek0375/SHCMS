package com.vivek.shcms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class MedicalRecordResponse {
        private String doctorName;
        private String diagnosis;
        private String notes;
        private String visitDate;
    }
