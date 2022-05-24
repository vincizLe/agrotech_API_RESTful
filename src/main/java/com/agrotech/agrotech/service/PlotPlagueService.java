package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.PlotPlague;
import com.agrotech.agrotech.domain.repository.IPlotRepository;
import com.agrotech.agrotech.domain.repository.IPlotPlagueRepository;
import com.agrotech.agrotech.domain.repository.IPlagueRepository;
import com.agrotech.agrotech.domain.service.IPlotPlagueService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlotPlagueService implements IPlotPlagueService {
    @Autowired
    private IPlotPlagueRepository plotPlagueRepository;

    @Autowired
    private IPlotRepository plotRepository;

    @Autowired
    private IPlagueRepository plagueRepository;

    @Override
    public Page<PlotPlague> getAllPlotPlagues(Pageable pageable) {
        return plotPlagueRepository.findAll(pageable);
    }

    @Override
    public PlotPlague getPlotPlagueById(Long plotPlagueId) {
        return plotPlagueRepository.findById(plotPlagueId).orElseThrow(
                () -> new ResourceNotFoundException("PlotPlague", "Id",plotPlagueId));
    }

    @Override
    public PlotPlague createPlotPlague(Long plotId, Long plagueId, PlotPlague plotPlague) {
        return plotRepository.findById(plotId).map(plot -> {
            plotPlague.setPlot(plot);
            return plagueRepository.findById(plagueId).map(plague -> {
                plotPlague.setPlague(plague);
                return plotPlagueRepository.save(plotPlague);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Plague", "Id", plagueId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Plot", "Id", plotId));
    }

    @Override
    public PlotPlague updatePlotPlague(Long plotPlagueId, PlotPlague plotPlagueRequest) {
        PlotPlague plotPlague = plotPlagueRepository.findById(plotPlagueId)
                .orElseThrow(()-> new ResourceNotFoundException("PlotPlague","Id",plotPlagueId));
        return plotPlagueRepository.save(plotPlague
                .setStartDate(plotPlagueRequest.getStartDate())
                .setEndDate(plotPlagueRequest.getEndDate())
                .setDamage(plotPlagueRequest.getDamage())
        );
    }

    @Override
    public ResponseEntity<?> deletePlotPlague(Long plotPlagueId) {
        PlotPlague plotPlague = plotPlagueRepository.findById(plotPlagueId).orElseThrow(
                ()-> new ResourceNotFoundException("PlotPlague","Id",plotPlagueId));
        plotPlagueRepository.delete(plotPlague);
        return ResponseEntity.ok().build();
    }
}
