package com.aiman.bloodapi.repository;

import com.aiman.bloodapi.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}

