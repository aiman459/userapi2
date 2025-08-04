package com.aiman.bloodapi.repository;

import com.aiman.bloodapi.model.PatientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRequestRepository extends JpaRepository<PatientRequest, Long> {
}
