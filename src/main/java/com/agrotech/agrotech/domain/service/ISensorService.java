package com.agrotech.agrotech.domain.service;

import com.agrotech.agrotech.domain.model.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ISensorService {
    Page<Sensor> getAllSensors(Pageable pageable);
    Sensor getSensorById(Long sensorId);
    Sensor createSensor(Sensor sensor);
    Sensor updateSensor(Long sensorId,Sensor sensorRequest);
    ResponseEntity<?> deleteSensor(Long sensorId);
}
