package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.PlotSensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPlotSensorService {
    Page<PlotSensor> getAllPlotSensors(Pageable pageable);
    PlotSensor getPlotSensorById(Long plotSensorId);
    PlotSensor createPlotSensor(Long plotId, Long sensorId, PlotSensor plotSensor);
    PlotSensor updatePlotSensor(Long plotSensorId, PlotSensor plotSensorRequest);
    ResponseEntity<?> deletePlotSensor(Long plotSensorId);
}
