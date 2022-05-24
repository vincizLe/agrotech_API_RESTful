package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ITreatmentService {
    Page<Treatment> getAllTreatments(Pageable pageable);
    Treatment getTreatmentById(Long treatmentId);
    Treatment createTreatment(Treatment treatment);
    Treatment updateTreatment(Long treatmentId,Treatment treatmentRequest);
    ResponseEntity<?> deleteTreatment(Long treatmentId);
}
