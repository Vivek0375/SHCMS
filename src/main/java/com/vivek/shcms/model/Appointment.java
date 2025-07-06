package com.vivek.shcms.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String patientEmail;
        private String doctorEmail;

        private LocalDateTime appointmentTime;

        private String reason;

        private String status; // PENDING, CONFIRMED, CANCELLED
    }


