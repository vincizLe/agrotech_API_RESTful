package com.agrotech.agrotech.domain.repository;

import com.agrotech.agrotech.domain.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreatmentRepository extends JpaRepository<Treatment, Long> {
}
