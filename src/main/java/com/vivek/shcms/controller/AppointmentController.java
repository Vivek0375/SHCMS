package com.vivek.shcms.controller;


import com.vivek.shcms.dto.AppointmentRequest;
import com.vivek.shcms.model.Appointment;
import com.vivek.shcms.service.AppointmentService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/appointments")
    public class AppointmentController {

        private final AppointmentService appointmentService;

        public AppointmentController(AppointmentService appointmentService) {
            this.appointmentService = appointmentService;
        }

        @PostMapping("/book")
        public Appointment book(@RequestBody AppointmentRequest request) {
            String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            return appointmentService.bookAppointment(email, request);
        }

        @GetMapping("/my")
        public List<Appointment> myAppointments() {
            String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            return appointmentService.getAppointmentsByPatient(email);
        }

        @GetMapping("/doctor")
        public List<Appointment> doctorAppointments() {
            String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            return appointmentService.getAppointmentsByDoctor(email);
        }
    }