package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.PlotTreatment;
import com.agrotech.agrotech.domain.repository.IPlotRepository;
import com.agrotech.agrotech.domain.repository.IPlotTreatmentRepository;
import com.agrotech.agrotech.domain.repository.ITreatmentRepository;
import com.agrotech.agrotech.domain.service.IPlotTreatmentService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlotTreatmentService implements IPlotTreatmentService {
    @Autowired
    private IPlotTreatmentRepository plotTreatmentRepository;

    @Autowired
    private IPlotRepository plotRepository;

    @Autowired
    private ITreatmentRepository treatmentRepository;

    @Override
    public Page<PlotTreatment> getAllPlotTreatments(Pageable pageable) {
        return plotTreatmentRepository.findAll(pageable);
    }

    @Override
    public PlotTreatment getPlotTreatmentById(Long plotTreatmentId) {
        return plotTreatmentRepository.findById(plotTreatmentId).orElseThrow(
                () -> new ResourceNotFoundException("PlotTreatment", "Id",plotTreatmentId));
    }

    @Override
    public PlotTreatment createPlotTreatment(Long plotId, Long treatmentId, PlotTreatment plotTreatment) {
        return plotRepository.findById(plotId).map(plot -> {
            plotTreatment.setPlot(plot);
            return treatmentRepository.findById(treatmentId).map(treatment -> {
                plotTreatment.setTreatment(treatment);
                return plotTreatmentRepository.save(plotTreatment);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Treatment", "Id", treatmentId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Plot", "Id", plotId));
    }

    @Override
    public PlotTreatment updatePlotTreatment(Long plotTreatmentId, PlotTreatment plotTreatmentRequest) {
        PlotTreatment plotTreatment = plotTreatmentRepository.findById(plotTreatmentId)
                .orElseThrow(()-> new ResourceNotFoundException("PlotTreatment","Id",plotTreatmentId));
        return plotTreatmentRepository.save(plotTreatment
                .setRecipe(plotTreatmentRequest.getRecipe())
                .setStartDate(plotTreatmentRequest.getStartDate())
                .setEndDate(plotTreatmentRequest.getEndDate())
        );
    }

    @Override
    public ResponseEntity<?> deletePlotTreatment(Long plotTreatmentId) {
        PlotTreatment plotTreatment = plotTreatmentRepository.findById(plotTreatmentId).orElseThrow(
                ()-> new ResourceNotFoundException("PlotTreatment","Id",plotTreatmentId));
        plotTreatmentRepository.delete(plotTreatment);
        return ResponseEntity.ok().build();
    }
}
