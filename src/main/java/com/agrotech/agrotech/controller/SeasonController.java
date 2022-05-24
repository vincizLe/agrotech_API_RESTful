package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Season;
import com.agrotech.agrotech.domain.service.ISeasonService;
import com.agrotech.agrotech.resource.SaveSeasonResource;
import com.agrotech.agrotech.resource.SeasonResource;
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

@Tag(name = "Seasons",description = "Seasons API")
@RestController
@RequestMapping("/api")
public class SeasonController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ISeasonService seasonService;

    private SeasonResource convertToResource(Season entity){
        return mapper.map(entity, SeasonResource.class);
    }
    private Season convertToEntity(SaveSeasonResource resource){
        return mapper.map(resource, Season.class);
    }

    @Operation(summary="Get All Seasons")
    @GetMapping("/seasons")
    public Page<SeasonResource> getAllSeasons(Pageable pageable){
        Page<Season> seasonPage = seasonService.getAllSeasons(pageable);
        List<SeasonResource> resources = seasonPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Season By Id")
    @GetMapping("/seasons/{seasonId}")
    public SeasonResource getSeasonById(@PathVariable(value = "seasonId") Long seasonId){
        return convertToResource(seasonService.getSeasonById(seasonId));
    }

    @Operation(summary="Create Season")
    @PostMapping("/seasons")
    public SeasonResource createSeason(@Valid @RequestBody SaveSeasonResource resource){
        Season season = convertToEntity(resource);
        return convertToResource(seasonService.createSeason(season));
    }

    @Operation(summary="Update Season")
    @PutMapping("/seasons/{seasonId}")
    public SeasonResource updateSeason(@PathVariable Long seasonId, @Valid @RequestBody SaveSeasonResource resource){
        Season season = convertToEntity(resource);
        return convertToResource(
                seasonService.updateSeason(seasonId,season));

    }

    @Operation(summary="Delete Season")
    @DeleteMapping("/seasons/{seasonId}")
    public ResponseEntity<?> deleteSeason(@PathVariable Long seasonId){
        return seasonService.deleteSeason(seasonId);
    }

}
