package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.PlotPlague;
import com.agrotech.agrotech.domain.service.IPlotPlagueService;
import com.agrotech.agrotech.resource.PlotPlagueResource;
import com.agrotech.agrotech.resource.SavePlotPlagueResource;
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

@Tag(name = "Plot_Plagues", description = "Plot Plagues API")
@RestController
@RequestMapping("/api")
public class PlotPlagueController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlotPlagueService plotPlagueService;

    private PlotPlagueResource convertToResource(PlotPlague entity){
        return mapper.map(entity, PlotPlagueResource.class);
    }
    private PlotPlague convertToEntity(SavePlotPlagueResource resource){
        return mapper.map(resource, PlotPlague.class);
    }

    @Operation(summary="Get All Plot Plagues")
    @GetMapping("/plotPlagues")
    public Page<PlotPlagueResource> getAllPlotPlagues(Pageable pageable){
        Page<PlotPlague> plotPlaguePage = plotPlagueService.getAllPlotPlagues(pageable);
        List<PlotPlagueResource> resources = plotPlaguePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plot Plague By Id")
    @GetMapping("/plotPlagues/{plotPlagueId}")
    public PlotPlagueResource getPlotPlagueById(@PathVariable(value = "plotPlagueId") Long plotPlagueId){
        return convertToResource(plotPlagueService.getPlotPlagueById(plotPlagueId));
    }

    @Operation(summary="Create Plot Plague")
    @PostMapping("/plots/{plotId}/plagues/{plagueId}")
    public PlotPlagueResource createPlotPlague(@PathVariable(value = "plotId") Long plotId,
                                               @PathVariable(value = "plagueId") Long plagueId,
                                               @Valid @RequestBody SavePlotPlagueResource resource){
        PlotPlague plotPlague = convertToEntity(resource);
        return convertToResource(plotPlagueService.createPlotPlague(plotId,plagueId,convertToEntity(resource)));
    }

    @Operation(summary="Update PlotPlague")
    @PutMapping("/plotPlagues/{plotPlagueId}")
    public PlotPlagueResource updatePlotPlague(@PathVariable Long plotPlagueId, @Valid @RequestBody SavePlotPlagueResource resource){
        PlotPlague plotPlague = convertToEntity(resource);
        return convertToResource(
                plotPlagueService.updatePlotPlague(plotPlagueId,plotPlague));

    }

    @Operation(summary="Delete PlotPlague")
    @DeleteMapping("/plotPlagues/{plotPlagueId}")
    public ResponseEntity<?> deletePlotPlague(@PathVariable Long plotPlagueId){
        return plotPlagueService.deletePlotPlague(plotPlagueId);
    }
}
