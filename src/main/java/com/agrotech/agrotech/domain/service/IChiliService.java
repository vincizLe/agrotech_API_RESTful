package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Chili;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IChiliService {
    Page<Chili> getAllChilies(Pageable pageable);
    Chili getChiliById(Long chiliId);
    Chili createChili(Chili chili);
    Chili updateChili(Long chiliId,Chili chiliRequest);
    ResponseEntity<?> deleteChili(Long chiliId);
}
