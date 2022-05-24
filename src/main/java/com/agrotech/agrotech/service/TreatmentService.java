package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Treatment;
import com.agrotech.agrotech.domain.repository.ITreatmentRepository;
import com.agrotech.agrotech.domain.service.ITreatmentService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService implements ITreatmentService {
    @Autowired
    private ITreatmentRepository treatmentRepository;

    @Override
    public Page<Treatment> getAllTreatments(Pageable pageable){
        return treatmentRepository.findAll(pageable);
    }

    @Override
    public Treatment getTreatmentById(Long treatmentId) {
        return treatmentRepository.findById(treatmentId).orElseThrow(
                () -> new ResourceNotFoundException("Treatment", "Id",treatmentId));
    }

    @Override
    public Treatment createTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    @Override
    public Treatment updateTreatment(Long treatmentId, Treatment treatmentRequest) {
        Treatment treatment = treatmentRepository.findById(treatmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Treatment","Id",treatmentId));
        return treatmentRepository.save(treatment
                .setType(treatmentRequest.getType())
                .setDescription(treatmentRequest.getDescription())
                .setCertification(treatmentRequest.getCertification())
        );
    }

    @Override
    public ResponseEntity<?> deleteTreatment(Long treatmentId) {
        Treatment treatment = treatmentRepository.findById(treatmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Treatment","Id",treatmentId));
        treatmentRepository.delete(treatment);
        return ResponseEntity.ok().build();
    }
}
