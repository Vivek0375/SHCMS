package com.vivek.shcms.dto;

import lombok.Data;
import java.time.LocalDateTime;

    @Data
    public class AppointmentRequest {
        private String doctorEmail;
        private LocalDateTime appointmentTime;
        private String reason;
    }

