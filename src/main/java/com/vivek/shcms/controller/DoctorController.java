package com.vivek.shcms.controller;

import com.vivek.shcms.dto.DoctorRequest;
import com.vivek.shcms.dto.DoctorResponse;
import com.vivek.shcms.model.Doctor;
import com.vivek.shcms.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/doctors")
    public class DoctorController {

        private final DoctorService doctorService;

        public DoctorController(DoctorService doctorService) {
            this.doctorService = doctorService;
        }

        @PostMapping("/add")
        public Doctor addDoctor(@RequestBody DoctorRequest request) {
            return doctorService.addDoctor(request);
        }

        @GetMapping("/all")
        public List<DoctorResponse> getAllDoctors() {
            return doctorService.getAllDoctors();
        }

        @DeleteMapping("/delete/{id}")
        public void deleteDoctor(@PathVariable Long id) {
            doctorService.deleteDoctor(id);
        }
    }
