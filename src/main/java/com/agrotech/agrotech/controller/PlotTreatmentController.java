package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.PlotTreatment;
import com.agrotech.agrotech.domain.service.IPlotTreatmentService;
import com.agrotech.agrotech.resource.PlotTreatmentResource;
import com.agrotech.agrotech.resource.SavePlotTreatmentResource;
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

@Tag(name = "Plot_Treatments", description = "Plot Treatments API")
@RestController
public class PlotTreatmentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlotTreatmentService plotTreatmentService;

    private PlotTreatmentResource convertToResource(PlotTreatment entity){
        return mapper.map(entity, PlotTreatmentResource.class);
    }
    private PlotTreatment convertToEntity(SavePlotTreatmentResource resource){
        return mapper.map(resource, PlotTreatment.class);
    }

    @Operation(summary="Get All Plot Treatments")
    @GetMapping("/plotTreatments")
    public Page<PlotTreatmentResource> getAllPlotTreatments(Pageable pageable){
        Page<PlotTreatment> plotTreatmentPage = plotTreatmentService.getAllPlotTreatments(pageable);
        List<PlotTreatmentResource> resources = plotTreatmentPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plot Treatment By Id")
    @GetMapping("/plotTreatments/{plotTreatmentId}")
    public PlotTreatmentResource getPlotTreatmentById(@PathVariable(value = "plotTreatmentId") Long plotTreatmentId){
        return convertToResource(plotTreatmentService.getPlotTreatmentById(plotTreatmentId));
    }

    @Operation(summary="Create Plot Treatment")
    @PostMapping("/plots/{plotId}/treatments/{treatmentId}")
    public PlotTreatmentResource createPlotTreatment(@PathVariable(value = "plotId") Long plotId,
                                               @PathVariable(value = "treatmentId") Long treatmentId,
                                               @Valid @RequestBody SavePlotTreatmentResource resource){
        PlotTreatment plotTreatment = convertToEntity(resource);
        return convertToResource(plotTreatmentService.createPlotTreatment(plotId,treatmentId,convertToEntity(resource)));
    }

    @Operation(summary="Update PlotTreatment")
    @PutMapping("/plotTreatments/{plotTreatmentId}")
    public PlotTreatmentResource updatePlotTreatment(@PathVariable Long plotTreatmentId, @Valid @RequestBody SavePlotTreatmentResource resource){
        PlotTreatment plotTreatment = convertToEntity(resource);
        return convertToResource(
                plotTreatmentService.updatePlotTreatment(plotTreatmentId,plotTreatment));

    }

    @Operation(summary="Delete PlotTreatment")
    @DeleteMapping("/plotTreatments/{plotTreatmentId}")
    public ResponseEntity<?> deletePlotTreatment(@PathVariable Long plotTreatmentId){
        return plotTreatmentService.deletePlotTreatment(plotTreatmentId);
    }
}
