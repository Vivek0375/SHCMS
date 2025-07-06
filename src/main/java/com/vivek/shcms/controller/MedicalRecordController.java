package com.vivek.shcms.controller;


import com.vivek.shcms.dto.MedicalRecordRequest;
import com.vivek.shcms.dto.MedicalRecordResponse;
import com.vivek.shcms.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

    @RestController
    @RequestMapping("/api/records")
    public class MedicalRecordController {

        private final MedicalRecordService medicalRecordService;

        public MedicalRecordController(MedicalRecordService medicalRecordService) {
            this.medicalRecordService = medicalRecordService;
        }

        @PostMapping("/add")
        public void addRecord(@RequestBody MedicalRecordRequest request) {
            medicalRecordService.addRecord(request);
        }

        @GetMapping("/patient/{email}")
        public List<MedicalRecordResponse> getPatientRecords(@PathVariable String email) {
            return medicalRecordService.getRecordsByPatient(email);
        }

        @PostMapping("/upload")
        public ResponseEntity<String> uploadReport(
                @RequestParam("file") MultipartFile file,
                @RequestParam("recordId") Long recordId) {
            String fileUrl = medicalRecordService.storeFile(file, recordId);
            return ResponseEntity.ok(fileUrl);
        }

    }
