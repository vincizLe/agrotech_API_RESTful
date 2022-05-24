package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.PlagueSeason;
import com.agrotech.agrotech.domain.repository.IPlagueRepository;
import com.agrotech.agrotech.domain.repository.IPlagueSeasonRepository;
import com.agrotech.agrotech.domain.repository.ISeasonRepository;
import com.agrotech.agrotech.domain.service.IPlagueSeasonService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlagueSeasonService implements IPlagueSeasonService {
    @Autowired
    private IPlagueSeasonRepository plagueSeasonRepository;

    @Autowired
    private IPlagueRepository plagueRepository;

    @Autowired
    private ISeasonRepository seasonRepository;

    @Override
    public Page<PlagueSeason> getAllPlagueSeasons(Pageable pageable) {
        return plagueSeasonRepository.findAll(pageable);
    }

    @Override
    public PlagueSeason getPlagueSeasonById(Long plagueSeasonId) {
        return plagueSeasonRepository.findById(plagueSeasonId).orElseThrow(
                () -> new ResourceNotFoundException("PlagueSeason", "Id",plagueSeasonId));
    }

    @Override
    public PlagueSeason createPlagueSeason(Long plagueId, Long seasonId, PlagueSeason plagueSeason) {
        return plagueRepository.findById(plagueId).map(plague -> {
            plagueSeason.setPlague(plague);
            return seasonRepository.findById(seasonId).map(season -> {
                plagueSeason.setSeason(season);
                return plagueSeasonRepository.save(plagueSeason);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Season", "Id", seasonId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Plague", "Id", plagueId));
    }

    @Override
    public ResponseEntity<?> deletePlagueSeason(Long plagueSeasonId) {
        PlagueSeason plagueSeason = plagueSeasonRepository.findById(plagueSeasonId).orElseThrow(
                ()-> new ResourceNotFoundException("PlagueSeason","Id",plagueSeasonId));
        plagueSeasonRepository.delete(plagueSeason);
        return ResponseEntity.ok().build();
    }
}
