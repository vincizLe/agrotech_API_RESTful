package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.PlotSensor;
import com.agrotech.agrotech.domain.service.IPlotSensorService;
import com.agrotech.agrotech.resource.PlotSensorResource;
import com.agrotech.agrotech.resource.SavePlotSensorResource;
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

@Tag(name = "Plot_Sensors", description = "Plot Sensors API")
@RestController
@RequestMapping("/api")
public class PlotSensorController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlotSensorService plotSensorService;

    private PlotSensorResource convertToResource(PlotSensor entity){
        return mapper.map(entity, PlotSensorResource.class);
    }
    private PlotSensor convertToEntity(SavePlotSensorResource resource){
        return mapper.map(resource, PlotSensor.class);
    }

    @Operation(summary="Get All Plot Sensors")
    @GetMapping("/plotSensors")
    public Page<PlotSensorResource> getAllPlotSensors(Pageable pageable){
        Page<PlotSensor> plotSensorPage = plotSensorService.getAllPlotSensors(pageable);
        List<PlotSensorResource> resources = plotSensorPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plot Sensor By Id")
    @GetMapping("/plotSensors/{plotSensorId}")
    public PlotSensorResource getPlotSensorById(@PathVariable(value = "plotSensorId") Long plotSensorId){
        return convertToResource(plotSensorService.getPlotSensorById(plotSensorId));
    }

    @Operation(summary="Create Plot Sensor")
    @PostMapping("/plots/{plotId}/sensors/{sensorId}")
    public PlotSensorResource createPlotSensor(@PathVariable(value = "plotId") Long plotId,
                                               @PathVariable(value = "sensorId") Long sensorId,
                                   @Valid @RequestBody SavePlotSensorResource resource){
        PlotSensor plotSensor = convertToEntity(resource);
        return convertToResource(plotSensorService.createPlotSensor(plotId,sensorId,convertToEntity(resource)));
    }

    @Operation(summary="Update PlotSensor")
    @PutMapping("/plotSensors/{plotSensorId}")
    public PlotSensorResource updatePlotSensor(@PathVariable Long plotSensorId, @Valid @RequestBody SavePlotSensorResource resource){
        PlotSensor plotSensor = convertToEntity(resource);
        return convertToResource(
                plotSensorService.updatePlotSensor(plotSensorId,plotSensor));

    }

    @Operation(summary="Delete PlotSensor")
    @DeleteMapping("/plotSensors/{plotSensorId}")
    public ResponseEntity<?> deletePlotSensor(@PathVariable Long plotSensorId){
        return plotSensorService.deletePlotSensor(plotSensorId);
    }

}
