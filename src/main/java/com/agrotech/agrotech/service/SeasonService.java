package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Season;
import com.agrotech.agrotech.domain.repository.ISeasonRepository;
import com.agrotech.agrotech.domain.service.ISeasonService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SeasonService implements ISeasonService {
    @Autowired
    private ISeasonRepository seasonRepository;

    @Override
    public Page<Season> getAllSeasons(Pageable pageable) {
        return seasonRepository.findAll(pageable);
    }

    @Override
    public Season getSeasonById(Long seasonId) {
        return seasonRepository.findById(seasonId).orElseThrow(
                () -> new ResourceNotFoundException("Season", "Id",seasonId));
    }

    @Override
    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season updateSeason(Long seasonId, Season seasonRequest) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(()-> new ResourceNotFoundException("Season","Id",seasonId));
        return seasonRepository.save(season
                .setDescription(seasonRequest.getDescription())
                .setStartDate(seasonRequest.getStartDate())
                .setEndDate(seasonRequest.getEndDate())
        );
    }

    @Override
    public ResponseEntity<?> deleteSeason(Long seasonId) {
        Season season = seasonRepository.findById(seasonId).orElseThrow(
                ()-> new ResourceNotFoundException("Season","Id",seasonId));
        seasonRepository.delete(season);
        return ResponseEntity.ok().build();
    }
}
