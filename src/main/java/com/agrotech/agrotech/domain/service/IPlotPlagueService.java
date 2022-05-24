package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.PlotPlague;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlotPlagueService {
    Page<PlotPlague> getAllPlotPlagues(Pageable pageable);
    PlotPlague getPlotPlagueById(Long plotPlagueId);
    PlotPlague createPlotPlague(Long plotId, Long plagueId, PlotPlague plotPlague);
    PlotPlague updatePlotPlague(Long plotPlagueId, PlotPlague plotPlagueRequest);
    ResponseEntity<?> deletePlotPlague(Long plotPlagueId);
}
