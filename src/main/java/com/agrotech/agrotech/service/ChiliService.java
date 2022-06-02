package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Chili;
import com.agrotech.agrotech.domain.repository.IChiliRepository;
import com.agrotech.agrotech.domain.service.IChiliService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChiliService implements IChiliService {
    @Autowired
    private IChiliRepository chiliRepository;

    @Override
    public Page<Chili>getAllChilies(Pageable pageable){
        return chiliRepository.findAll(pageable);
    }

    @Override
    public Chili getChiliById(Long chiliId) {
        return chiliRepository.findById(chiliId).orElseThrow(
                () -> new ResourceNotFoundException("Chili", "Id",chiliId));
    }

    @Override
    public Chili createChili(Chili chili) {
        return chiliRepository.save(chili);
    }

    @Override
    public Chili updateChili(Long chiliId, Chili chiliRequest) {
        Chili chili = chiliRepository.findById(chiliId)
                .orElseThrow(()-> new ResourceNotFoundException("Chili","Id",chiliId));
        return chiliRepository.save(chili
                .setName(chiliRequest.getName())
                .setDescription(chiliRequest.getDescription())
                .setChiliImage(chiliRequest.getChiliImage())
        );
    }

    @Override
    public ResponseEntity<?> deleteChili(Long chiliId) {
        Chili chili = chiliRepository.findById(chiliId).orElseThrow(
                ()-> new ResourceNotFoundException("Chili","Id",chiliId));
        chiliRepository.delete(chili);
        return ResponseEntity.ok().build();
    }
}
