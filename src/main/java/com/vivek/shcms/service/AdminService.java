package com.vivek.shcms.service;


import com.vivek.shcms.dto.AdminDashboardResponse;
import com.vivek.shcms.model.Doctor;
import com.vivek.shcms.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class AdminService {

        private final UserRepository userRepo;
        private final AppointmentRepository appointmentRepo;
        private final MedicalRecordRepository recordRepo;
        private final DoctorRepository doctorRepo;

        public AdminService(UserRepository userRepo, AppointmentRepository appointmentRepo,
                            MedicalRecordRepository recordRepo, DoctorRepository doctorRepo) {
            this.userRepo = userRepo;
            this.appointmentRepo = appointmentRepo;
            this.recordRepo = recordRepo;
            this.doctorRepo = doctorRepo;
        }

        public AdminDashboardResponse getDashboardStats() {
            long totalUsers = userRepo.count();
            long totalPatients = userRepo.findAll().stream().filter(u -> u.getRole().equalsIgnoreCase("PATIENT")).count();
            long totalDoctors = userRepo.findAll().stream().filter(u -> u.getRole().equalsIgnoreCase("DOCTOR")).count();
            long totalAppointments = appointmentRepo.count();
            long totalMedicalRecords = recordRepo.count();

            List<String> topDoctors = appointmentRepo.findAll().stream()
                    .collect(Collectors.groupingBy(a -> a.getDoctorEmail(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .limit(5)
                    .map(e -> {
                        Doctor d = doctorRepo.findAll().stream()
                                .filter(doc -> doc.getEmail().equals(e.getKey()))
                                .findFirst().orElse(null);
                        return d != null ? d.getName() + " (" + e.getValue() + " appts)" : e.getKey();
                    })
                    .collect(Collectors.toList());

            return new AdminDashboardResponse(
                    totalUsers,
                    totalPatients,
                    totalDoctors,
                    totalAppointments,
                    totalMedicalRecords,
                    topDoctors
            );
        }
    }
