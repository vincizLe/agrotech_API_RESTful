package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Season;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ISeasonService{
    Page<Season> getAllSeasons(Pageable pageable);
    Season getSeasonById(Long seasonId);
    Season createSeason(Season season);
    Season updateSeason(Long seasonId,Season seasonRequest);
    ResponseEntity<?> deleteSeason(Long seasonId);
}
