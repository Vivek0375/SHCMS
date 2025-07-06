package com.vivek.shcms.dto;

import lombok.Data;

    @Data
    public class MedicalRecordRequest {
        private String patientEmail;
        private String doctorName;
        private String diagnosis;
        private String notes;
        private String visitDate; // in "yyyy-MM-dd"
    }
