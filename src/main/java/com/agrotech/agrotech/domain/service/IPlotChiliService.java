package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.PlotChili;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlotChiliService {
    Page<PlotChili> getAllPlotChilies(Pageable pageable);
    PlotChili getPlotChiliById(Long plotChiliId);
    PlotChili createPlotChili(Long plotId, Long chiliId, PlotChili plotChili);
    PlotChili updatePlotChili(Long plotChiliId, PlotChili plotChiliRequest);
    ResponseEntity<?> deletePlotChili(Long plotChiliId);
}
