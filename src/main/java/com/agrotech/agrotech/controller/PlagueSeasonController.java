package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.PlagueSeason;
import com.agrotech.agrotech.domain.service.IPlagueSeasonService;
import com.agrotech.agrotech.resource.PlagueSeasonResource;
import com.agrotech.agrotech.resource.SavePlagueSeasonResource;
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

@Tag(name = "Plague_Seasons", description = "Plague Seasons API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlagueSeasonController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IPlagueSeasonService plagueSeasonService;

    private PlagueSeasonResource convertToResource(PlagueSeason entity){
        return mapper.map(entity, PlagueSeasonResource.class);
    }
    private PlagueSeason convertToEntity(SavePlagueSeasonResource resource){
        return mapper.map(resource, PlagueSeason.class);
    }

    @Operation(summary="Get All Plague Seasons")
    @GetMapping("/plagueSeasons")
    public Page<PlagueSeasonResource> getAllPlagueSeasons(Pageable pageable){
        Page<PlagueSeason> plagueSeasonPage = plagueSeasonService.getAllPlagueSeasons(pageable);
        List<PlagueSeasonResource> resources = plagueSeasonPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Plague Season By Id")
    @GetMapping("/plagueSeasons/{plagueSeasonId}")
    public PlagueSeasonResource getPlagueSeasonById(@PathVariable(value = "plagueSeasonId") Long plagueSeasonId){
        return convertToResource(plagueSeasonService.getPlagueSeasonById(plagueSeasonId));
    }

    @Operation(summary="Create Plague Season")
    @PostMapping("/plagues/{plagueId}/seasons/{seasonId}")
    public PlagueSeasonResource createPlagueSeason(@PathVariable(value = "plagueId") Long plagueId,
                                               @PathVariable(value = "seasonId") Long seasonId,
                                               @Valid @RequestBody SavePlagueSeasonResource resource){
        PlagueSeason plagueSeason = convertToEntity(resource);
        return convertToResource(plagueSeasonService.createPlagueSeason(plagueId,seasonId,convertToEntity(resource)));
    }

    @Operation(summary="Delete PlagueSeason")
    @DeleteMapping("/plagueSeasons/{plagueSeasonId}")
    public ResponseEntity<?> deletePlagueSeason(@PathVariable Long plagueSeasonId){
        return plagueSeasonService.deletePlagueSeason(plagueSeasonId);
    }
}
