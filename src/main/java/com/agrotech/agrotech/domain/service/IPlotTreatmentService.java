package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.PlotTreatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlotTreatmentService {
    Page<PlotTreatment> getAllPlotTreatments(Pageable pageable);
    PlotTreatment getPlotTreatmentById(Long plotTreatmentId);
    PlotTreatment createPlotTreatment(Long plotId, Long treatmentId, PlotTreatment plotTreatment);
    PlotTreatment updatePlotTreatment(Long plotTreatmentId, PlotTreatment plotTreatmentRequest);
    ResponseEntity<?> deletePlotTreatment(Long plotTreatmentId);
}
