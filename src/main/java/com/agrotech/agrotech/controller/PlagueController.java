package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Plague;
import com.agrotech.agrotech.domain.service.IPlagueService;
import com.agrotech.agrotech.resource.SavePlagueResource;
import com.agrotech.agrotech.resource.PlagueResource;
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

@Tag(name = "Plagues",description = "Plagues API")
@RestController
@RequestMapping("/api")
public class PlagueController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlagueService plagueService;

    private PlagueResource convertToResource(Plague entity){
        return mapper.map(entity, PlagueResource.class);
    }
    private Plague convertToEntity(SavePlagueResource resource){
        return mapper.map(resource, Plague.class);
    }

    @Operation(summary="Get All Plagues")
    @GetMapping("/plagues")
    public Page<PlagueResource> getAllPlagues(Pageable pageable){
        Page<Plague> plaguePage = plagueService.getAllPlagues(pageable);
        List<PlagueResource> resources = plaguePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plague By Id")
    @GetMapping("/plagues/{plagueId}")
    public PlagueResource getPlagueById(@PathVariable(value = "plagueId") Long plagueId){
        return convertToResource(plagueService.getPlagueById(plagueId));
    }

    @Operation(summary="Create Plague")
    @PostMapping("/plagues")
    public PlagueResource createPlague(@Valid @RequestBody SavePlagueResource resource){
        Plague plague = convertToEntity(resource);
        return convertToResource(plagueService.createPlague(plague));
    }

    @Operation(summary="Update Plague")
    @PutMapping("/plagues/{plagueId}")
    public PlagueResource updatePlague(@PathVariable Long plagueId, @Valid @RequestBody SavePlagueResource resource){
        Plague plague = convertToEntity(resource);
        return convertToResource(
                plagueService.updatePlague(plagueId,plague));

    }

    @Operation(summary="Delete Plague")
    @DeleteMapping("/plagues/{plagueId}")
    public ResponseEntity<?> deletePlague(@PathVariable Long plagueId){
        return plagueService.deletePlague(plagueId);
    }
}
