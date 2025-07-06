package com.vivek.shcms.service;

import com.vivek.shcms.dto.MedicalRecordRequest;
import com.vivek.shcms.dto.MedicalRecordResponse;
import com.vivek.shcms.model.MedicalRecord;
import com.vivek.shcms.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class MedicalRecordService {

        private final MedicalRecordRepository medicalRecordRepository;

        public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
            this.medicalRecordRepository = medicalRecordRepository;
        }

        public void addRecord(MedicalRecordRequest request) {
            MedicalRecord record = MedicalRecord.builder()
                    .patientEmail(request.getPatientEmail())
                    .doctorName(request.getDoctorName())
                    .diagnosis(request.getDiagnosis())
                    .notes(request.getNotes())
                    .visitDate(LocalDate.parse(request.getVisitDate()))
                    .build();
            medicalRecordRepository.save(record);
        }

        public String storeFile(MultipartFile file, Long recordId) {
            try {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path uploadDir = Paths.get("uploads");
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }

                Path filePath = uploadDir.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                MedicalRecord record = medicalRecordRepository.findById(recordId)
                        .orElseThrow(() -> new RuntimeException("Record not found"));
                record.setReportUrl(filePath.toString());
                medicalRecordRepository.save(record);

                return filePath.toString();
            } catch (Exception e) {
                throw new RuntimeException("File upload failed", e);
            }
        }

        public List<MedicalRecordResponse> getRecordsByPatient(String email) {
            return medicalRecordRepository.findByPatientEmail(email)
                    .stream()
                    .map(rec -> new MedicalRecordResponse(
                            rec.getDoctorName(), rec.getDiagnosis(), rec.getNotes(), rec.getVisitDate().toString()))
                    .collect(Collectors.toList());
        }
    }
