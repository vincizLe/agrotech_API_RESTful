package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Plot;
import com.agrotech.agrotech.domain.repository.IPlotRepository;
import com.agrotech.agrotech.domain.repository.IUserRepository;
import com.agrotech.agrotech.domain.service.IPlotService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlotService implements IPlotService {
    @Autowired
    private IPlotRepository plotRepository;

    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public Page<Plot> getAllPlots(Pageable pageable) {
        return plotRepository.findAll(pageable);
    }

    @Override
    public Plot getPlotById(Long plotId) {
        return plotRepository.findById(plotId).orElseThrow(
                () -> new ResourceNotFoundException("Plot", "Id",plotId));

    }

    @Override
    public Plot createPlot(Long userId, Plot plot) {
        return userRepository.findById(userId).map(user -> {
            plot.setUser(user);
            return plotRepository.save(plot);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "User", "Id", userId));
    }


    @Override
    public Plot updatePlot(Long plotId, Plot plotRequest) {
        Plot plot = plotRepository.findById(plotId)
                .orElseThrow(()-> new ResourceNotFoundException("Plot","Id",plotId));
        return plotRepository.save(plot
                .setName(plotRequest.getName())
                .setDescription(plotRequest.getDescription())
                .setLocation(plotRequest.getLocation())
                .setArea(plotRequest.getArea())
                .setVolume(plotRequest.getVolume())
                .setPlotImage(plotRequest.getPlotImage())
                //.setUser(plotRequest.getUser())
        );
    }

    @Override
    public ResponseEntity<?> deletePlot(Long plotId) {
        Plot plot = plotRepository.findById(plotId).orElseThrow(
                ()-> new ResourceNotFoundException("Plot","Id",plotId));
        plotRepository.delete(plot);
        return ResponseEntity.ok().build();
    }
}
