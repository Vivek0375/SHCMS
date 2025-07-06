package com.vivek.shcms.repository;


import com.vivek.shcms.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
        List<MedicalRecord> findByPatientEmail(String patientEmail);
    }