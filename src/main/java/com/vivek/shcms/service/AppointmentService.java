package com.vivek.shcms.service;

import com.vivek.shcms.dto.AppointmentRequest;
import com.vivek.shcms.model.Appointment;
import com.vivek.shcms.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class AppointmentService {

        private final AppointmentRepository appointmentRepository;

        public AppointmentService(AppointmentRepository appointmentRepository) {
            this.appointmentRepository = appointmentRepository;
        }

        public Appointment bookAppointment(String patientEmail, AppointmentRequest request) {
            Appointment appointment = Appointment.builder()
                    .patientEmail(patientEmail)
                    .doctorEmail(request.getDoctorEmail())
                    .appointmentTime(request.getAppointmentTime())
                    .reason(request.getReason())
                    .status("PENDING")
                    .build();

            return appointmentRepository.save(appointment);
        }

        public List<Appointment> getAppointmentsByPatient(String email) {
            return appointmentRepository.findByPatientEmail(email);
        }

        public List<Appointment> getAppointmentsByDoctor(String email) {
            return appointmentRepository.findByDoctorEmail(email);
        }
    }
