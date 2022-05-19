package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Plot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlotService {
    Page<Plot> getAllPlots(Pageable pageable);
    Plot getPlotById(Long plotId);
    Plot createPlot(Long userId,Plot plot);
    Plot updatePlot(Long plotId,Plot plotRequest);
    ResponseEntity<?> deletePlot(Long plotId);
}
