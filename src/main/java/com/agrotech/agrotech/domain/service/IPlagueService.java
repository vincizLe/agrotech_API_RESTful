package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Plague;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlagueService {
    Page<Plague> getAllPlagues(Pageable pageable);
    Plague getPlagueById(Long plaguesId);
    Plague createPlague(Plague plagues);
    Plague updatePlague(Long plaguesId,Plague plaguesRequest);
    ResponseEntity<?> deletePlague(Long plaguesId);
}
