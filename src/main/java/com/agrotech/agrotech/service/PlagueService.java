package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Plague;
import com.agrotech.agrotech.domain.repository.IPlagueRepository;
import com.agrotech.agrotech.domain.service.IPlagueService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlagueService implements IPlagueService {
    @Autowired
    private IPlagueRepository plagueRepository;

    @Override
    public Page<Plague> getAllPlagues(Pageable pageable) {
        return plagueRepository.findAll(pageable);
    }

    @Override
    public Plague getPlagueById(Long plagueId) {
        return plagueRepository.findById(plagueId).orElseThrow(
                () -> new ResourceNotFoundException("Plague", "Id",plagueId));
    }

    @Override
    public Plague createPlague(Plague plague) {
        return plagueRepository.save(plague);
    }

    @Override
    public Plague updatePlague(Long plagueId, Plague plagueRequest) {
        Plague plague = plagueRepository.findById(plagueId)
                .orElseThrow(()-> new ResourceNotFoundException("Plague","Id",plagueId));
        return plagueRepository.save(plague
                .setDescription(plagueRequest.getDescription())
                .setType(plagueRequest.getType())
                .setPhThreshold(plagueRequest.getPhThreshold())
                .setTemperatureThreshold(plagueRequest.getTemperatureThreshold())
                .setHumidityThreshold(plagueRequest.getHumidityThreshold())
                .setCo2Threshold(plagueRequest.getCo2Threshold())
                .setElectricConductivityThreshold(plagueRequest.getElectricConductivityThreshold())
        );
    }

    @Override
    public ResponseEntity<?> deletePlague(Long plagueId) {
        Plague plague = plagueRepository.findById(plagueId).orElseThrow(
                ()-> new ResourceNotFoundException("Plague","Id",plagueId));
        plagueRepository.delete(plague);
        return ResponseEntity.ok().build();
    }
}
