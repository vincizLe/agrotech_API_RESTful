package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Sensor;
import com.agrotech.agrotech.domain.service.ISensorService;
import com.agrotech.agrotech.resource.SensorResource;
import com.agrotech.agrotech.resource.SaveSensorResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Sensors",description = "Sensors API")
@RestController
@RequestMapping("/api")
public class SensorController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ISensorService sensorService;

    private SensorResource convertToResource(Sensor entity){
        return mapper.map(entity, SensorResource.class);
    }
    private Sensor convertToEntity(SaveSensorResource resource){
        return mapper.map(resource, Sensor.class);
    }

    @Operation(summary="Get All Sensors")
    @GetMapping("/sensors")
    public Page<SensorResource> getAllSensors(Pageable pageable){
        Page<Sensor> sensorPage = sensorService.getAllSensors(pageable);
        List<SensorResource> resources = sensorPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Sensor By Id")
    @GetMapping("/sensors/{sensorId}")
    public SensorResource getSensorById(@PathVariable(value = "sensorId") Long sensorId){
        return convertToResource(sensorService.getSensorById(sensorId));
    }

    @Operation(summary="Create Sensor")
    @PostMapping("/sensors")
    public SensorResource createSensor(@Valid @RequestBody SaveSensorResource resource){
        Sensor sensor = convertToEntity(resource);
        return convertToResource(sensorService.createSensor(sensor));
    }

    @Operation(summary="Update Sensor")
    @PutMapping("/sensors/{sensorId}")
    public SensorResource updateSensor(@PathVariable Long sensorId, @Valid @RequestBody SaveSensorResource resource){
        Sensor sensor = convertToEntity(resource);
        return convertToResource(
                sensorService.updateSensor(sensorId,sensor));

    }

    @Operation(summary="Delete Sensor")
    @DeleteMapping("/sensors/{sensorId}")
    public ResponseEntity<?> deleteSensor(@PathVariable Long sensorId){
        return sensorService.deleteSensor(sensorId);
    }

}
