package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Plot;
import com.agrotech.agrotech.domain.model.PlotSensor;
import com.agrotech.agrotech.domain.repository.IPlotRepository;
import com.agrotech.agrotech.domain.repository.IPlotSensorRepository;
import com.agrotech.agrotech.domain.repository.ISensorRepository;
import com.agrotech.agrotech.domain.repository.IUserRepository;
import com.agrotech.agrotech.domain.service.IPlotSensorService;
import com.agrotech.agrotech.domain.service.IPlotService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlotSensorService implements IPlotSensorService {
    @Autowired
    private IPlotSensorRepository plotSensorRepository;

    @Autowired
    private IPlotRepository plotRepository;

    @Autowired
    private ISensorRepository sensorRepository;

    @Override
    public Page<PlotSensor> getAllPlotSensors(Pageable pageable) {
        return plotSensorRepository.findAll(pageable);
    }

    @Override
    public PlotSensor getPlotSensorById(Long plotSensorId) {
        return plotSensorRepository.findById(plotSensorId).orElseThrow(
                () -> new ResourceNotFoundException("PlotSensor", "Id",plotSensorId));
    }

    @Override
    public PlotSensor createPlotSensor(Long plotId, Long sensorId, PlotSensor plotSensor) {
        return plotRepository.findById(plotId).map(plot -> {
            plotSensor.setPlot(plot);
            return sensorRepository.findById(sensorId).map(sensor -> {
                plotSensor.setSensor(sensor);
                return plotSensorRepository.save(plotSensor);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Sensor", "Id", sensorId));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Plot", "Id", plotId));
    }

    @Override
    public PlotSensor updatePlotSensor(Long plotSensorId, PlotSensor plotSensorRequest) {
        PlotSensor plotSensor = plotSensorRepository.findById(plotSensorId)
                .orElseThrow(()-> new ResourceNotFoundException("PlotSensor","Id",plotSensorId));
        return plotSensorRepository.save(plotSensor
                .setQuantity(plotSensorRequest.getQuantity())
                .setLocation(plotSensorRequest.getLocation())
        );
    }

    @Override
    public ResponseEntity<?> deletePlotSensor(Long plotSensorId) {
        PlotSensor plotSensor = plotSensorRepository.findById(plotSensorId).orElseThrow(
                ()-> new ResourceNotFoundException("PlotSensor","Id",plotSensorId));
        plotSensorRepository.delete(plotSensor);
        return ResponseEntity.ok().build();
    }
}
