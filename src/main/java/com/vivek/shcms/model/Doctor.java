package com.vivek.shcms.model;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Doctor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String email;

        private String specialization;

        private int experienceYears;

        private String hospital;

        private String contact;
    }