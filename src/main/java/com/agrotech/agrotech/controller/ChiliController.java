package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Chili;
import com.agrotech.agrotech.domain.service.IChiliService;
import com.agrotech.agrotech.resource.SaveChiliResource;
import com.agrotech.agrotech.resource.ChiliResource;
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

@Tag(name = "Chilies", description = "Chilies API")
@RestController
@RequestMapping("/api")
public class ChiliController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IChiliService chiliService;

    private ChiliResource convertToResource(Chili entity){
        return mapper.map(entity, ChiliResource.class);
    }
    private Chili convertToEntity(SaveChiliResource resource){
        return mapper.map(resource, Chili.class);
    }

    @Operation(summary="Get All Chilies")
    @GetMapping("/chilies")
    public Page<ChiliResource> getAllChilies(Pageable pageable){
        Page<Chili> chiliPage = chiliService.getAllChilies(pageable);
        List<ChiliResource> resources = chiliPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Chili By Id")
    @GetMapping("/chilies/{chiliId}")
    public ChiliResource getChiliById(@PathVariable(value = "chiliId") Long chiliId){
        return convertToResource(chiliService.getChiliById(chiliId));
    }

    @Operation(summary="Create Chili")
    @PostMapping("/chilies")
    public ChiliResource createChili(@Valid @RequestBody SaveChiliResource resource){
        Chili chili = convertToEntity(resource);
        return convertToResource(chiliService.createChili(chili));
    }

    @Operation(summary="Update Chili")
    @PutMapping("/chilies/{chiliId}")
    public ChiliResource updateChili(@PathVariable Long chiliId, @Valid @RequestBody SaveChiliResource resource){
        Chili chili = convertToEntity(resource);
        return convertToResource(
                chiliService.updateChili(chiliId,chili));

    }

    @Operation(summary="Delete Chili")
    @DeleteMapping("/chilies/{chiliId}")
    public ResponseEntity<?> deleteChili(@PathVariable Long chiliId){
        return chiliService.deleteChili(chiliId);
    }
}
