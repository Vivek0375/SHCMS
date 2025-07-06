package com.vivek.shcms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class MedicalRecord {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String patientEmail;

        private String doctorName;

        private String diagnosis;

        private String notes;

        private LocalDate visitDate;

        private String reportUrl; // Optional (for file uploads later)
    }
