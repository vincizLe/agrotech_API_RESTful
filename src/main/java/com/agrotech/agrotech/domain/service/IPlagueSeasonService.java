package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.PlagueSeason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlagueSeasonService {
    Page<PlagueSeason> getAllPlagueSeasons(Pageable pageable);
    PlagueSeason getPlagueSeasonById(Long plagueSeasonId);
    PlagueSeason createPlagueSeason(Long plagueId, Long seasonId, PlagueSeason plagueSeason);
    ResponseEntity<?> deletePlagueSeason(Long plagueSeasonId);
}
