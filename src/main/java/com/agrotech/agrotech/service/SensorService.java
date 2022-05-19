package com.agrotech.agrotech.service;

import com.agrotech.agrotech.domain.model.Sensor;
import com.agrotech.agrotech.domain.repository.ISensorRepository;
import com.agrotech.agrotech.domain.service.ISensorService;
import com.agrotech.agrotech.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SensorService implements ISensorService {
    @Autowired
    private ISensorRepository sensorRepository;
    
    @Override
    public Page<Sensor> getAllSensors(Pageable pageable) {
        return sensorRepository.findAll(pageable);
    }

    @Override
    public Sensor getSensorById(Long sensorId) {
        return sensorRepository.findById(sensorId).orElseThrow(
                () -> new ResourceNotFoundException("Sensor", "Id",sensorId));
    }

    @Override
    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor updateSensor(Long sensorId, Sensor sensorRequest) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(()-> new ResourceNotFoundException("Sensor","Id",sensorId));
        return sensorRepository.save(sensor
                .setName(sensorRequest.getName())
                .setType(sensorRequest.getType())
                .setDescription(sensorRequest.getDescription())
                .setUsefulLife(sensorRequest.getUsefulLife())
        );
    }

    @Override
    public ResponseEntity<?> deleteSensor(Long sensorId) {
        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow(
                ()-> new ResourceNotFoundException("Sensor","Id",sensorId));
        sensorRepository.delete(sensor);
        return ResponseEntity.ok().build();
    }
}
