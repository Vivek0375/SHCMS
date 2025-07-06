package com.vivek.shcms.repository;

import com.vivek.shcms.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface DoctorRepository extends JpaRepository<Doctor, Long> {
        boolean existsByEmail(String email);
    }
