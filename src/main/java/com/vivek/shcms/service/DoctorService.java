package com.vivek.shcms.service;

import com.vivek.shcms.dto.DoctorRequest;
import com.vivek.shcms.dto.DoctorResponse;
import com.vivek.shcms.model.Doctor;
import com.vivek.shcms.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class DoctorService {

        private final DoctorRepository doctorRepository;

        public DoctorService(DoctorRepository doctorRepository) {
            this.doctorRepository = doctorRepository;
        }

        public Doctor addDoctor(DoctorRequest request) {
            Doctor doctor = Doctor.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .specialization(request.getSpecialization())
                    .experienceYears(request.getExperienceYears())
                    .hospital(request.getHospital())
                    .contact(request.getContact())
                    .build();
            return doctorRepository.save(doctor);
        }

        public List<DoctorResponse> getAllDoctors() {
            return doctorRepository.findAll().stream()
                    .map(doc -> new DoctorResponse(doc.getId(), doc.getName(), doc.getSpecialization(), doc.getHospital()))
                    .collect(Collectors.toList());
        }

        public void deleteDoctor(Long id) {
            doctorRepository.deleteById(id);
        }
    }