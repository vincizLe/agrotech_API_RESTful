package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.PlotChili;
import com.agrotech.agrotech.domain.service.IPlotChiliService;
import com.agrotech.agrotech.resource.PlotChiliResource;
import com.agrotech.agrotech.resource.SavePlotChiliResource;
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

@Tag(name = "Plot_Chilies", description = "Plot Chilies API")
@RestController
@RequestMapping("/api")
public class PloChiliController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlotChiliService plotChiliService;

    private PlotChiliResource convertToResource(PlotChili entity){
        return mapper.map(entity, PlotChiliResource.class);
    }
    private PlotChili convertToEntity(SavePlotChiliResource resource){
        return mapper.map(resource, PlotChili.class);
    }

    @Operation(summary="Get All Plot Chilies")
    @GetMapping("/plotChilies")
    public Page<PlotChiliResource> getAllPlotChilies(Pageable pageable){
        Page<PlotChili> plotChiliPage = plotChiliService.getAllPlotChilies(pageable);
        List<PlotChiliResource> resources = plotChiliPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plot Chili By Id")
    @GetMapping("/plotChilies/{plotChiliId}")
    public PlotChiliResource getPlotChiliById(@PathVariable(value = "plotChiliId") Long plotChiliId){
        return convertToResource(plotChiliService.getPlotChiliById(plotChiliId));
    }

    @Operation(summary="Create Plot Chili")
    @PostMapping("/plots/{plotId}/chilies/{chiliId}")
    public PlotChiliResource createPlotChili(@PathVariable(value = "plotId") Long plotId,
                                               @PathVariable(value = "chiliId") Long chiliId,
                                               @Valid @RequestBody SavePlotChiliResource resource){
        PlotChili plotChili = convertToEntity(resource);
        return convertToResource(plotChiliService.createPlotChili(plotId,chiliId,convertToEntity(resource)));
    }

    @Operation(summary="Update PlotChili")
    @PutMapping("/plotChilies/{plotChiliId}")
    public PlotChiliResource updatePlotChili(@PathVariable Long plotChiliId, @Valid @RequestBody SavePlotChiliResource resource){
        PlotChili plotChili = convertToEntity(resource);
        return convertToResource(
                plotChiliService.updatePlotChili(plotChiliId,plotChili));

    }

    @Operation(summary="Delete PlotChili")
    @DeleteMapping("/plotChilies/{plotChiliId}")
    public ResponseEntity<?> deletePlotChili(@PathVariable Long plotChiliId){
        return plotChiliService.deletePlotChili(plotChiliId);
    }
}
