package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Plot;
import com.agrotech.agrotech.domain.service.IPlotService;
import com.agrotech.agrotech.resource.SavePlotResource;
import com.agrotech.agrotech.resource.PlotResource;
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

@Tag(name = "Plots", description = "Plots API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlotController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlotService plotService;

    private PlotResource convertToResource(Plot entity){
        return mapper.map(entity, PlotResource.class);
    }
    private Plot convertToEntity(SavePlotResource resource){
        return mapper.map(resource, Plot.class);
    }

    @Operation(summary="Get All Plots")
    @GetMapping("/plots")
    public Page<PlotResource> getAllPlots(Pageable pageable){
        Page<Plot> plotPage = plotService.getAllPlots(pageable);
        List<PlotResource> resources = plotPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plot By Id")
    @GetMapping("/plots/{plotId}")
    public PlotResource getPlotById(@PathVariable(value = "plotId") Long plotId){
        return convertToResource(plotService.getPlotById(plotId));
    }

    @Operation(summary="Create Plot")
    @PostMapping("users/{userId}/plots")
    public PlotResource createPlot(@PathVariable(value = "userId") Long userId,
                                   @Valid @RequestBody SavePlotResource resource){
        Plot plot = convertToEntity(resource);
        return convertToResource(plotService.createPlot(userId,convertToEntity(resource)));
    }

    @Operation(summary="Update Plot")
    @PutMapping("/plots/{plotId}")
    public PlotResource updatePlot(@PathVariable Long plotId, @Valid @RequestBody SavePlotResource resource){
        Plot plot = convertToEntity(resource);
        return convertToResource(
                plotService.updatePlot(plotId,plot));

    }

    @Operation(summary="Delete Plot")
    @DeleteMapping("/plots/{plotId}")
    public ResponseEntity<?> deletePlot(@PathVariable Long plotId){
        return plotService.deletePlot(plotId);
    }
}
