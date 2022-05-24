package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.PlotChili;
import com.agrotech.agrotech.domain.repository.IPlotRepository;
import com.agrotech.agrotech.domain.repository.IPlotChiliRepository;
import com.agrotech.agrotech.domain.repository.IChiliRepository;
import com.agrotech.agrotech.domain.service.IPlotChiliService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlotChiliService implements IPlotChiliService {
    @Autowired
    private IPlotChiliRepository plotChiliRepository;

    @Autowired
    private IPlotRepository plotRepository;

    @Autowired
    private IChiliRepository chiliRepository;

    @Override
    public Page<PlotChili> getAllPlotChilies(Pageable pageable) {
        return plotChiliRepository.findAll(pageable);
    }

    @Override
    public PlotChili getPlotChiliById(Long plotChiliId) {
        return plotChiliRepository.findById(plotChiliId).orElseThrow(
                () -> new ResourceNotFoundException("PlotChili", "Id",plotChiliId));
    }

    @Override
    public PlotChili createPlotChili(Long plotId, Long chiliId, PlotChili plotChili) {
        return plotRepository.findById(plotId).map(plot -> {
            plotChili.setPlot(plot);
            return chiliRepository.findById(chiliId).map(chili -> {
                plotChili.setChili(chili);
                return plotChiliRepository.save(plotChili);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Chili", "Id", chiliId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Plot", "Id", plotId));
    }

    @Override
    public PlotChili updatePlotChili(Long plotChiliId, PlotChili plotChiliRequest) {
        PlotChili plotChili = plotChiliRepository.findById(plotChiliId)
                .orElseThrow(()-> new ResourceNotFoundException("PlotChili","Id",plotChiliId));
        return plotChiliRepository.save(plotChili
                .setLocation(plotChiliRequest.getLocation())
                .setStartDate(plotChiliRequest.getStartDate())
                .setEndDate(plotChiliRequest.getEndDate())
        );
    }

    @Override
    public ResponseEntity<?> deletePlotChili(Long plotChiliId) {
        PlotChili plotChili = plotChiliRepository.findById(plotChiliId).orElseThrow(
                ()-> new ResourceNotFoundException("PlotChili","Id",plotChiliId));
        plotChiliRepository.delete(plotChili);
        return ResponseEntity.ok().build();
    }
}
