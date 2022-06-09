package com.agrotech.agrotech.controller;

import com.agrotech.agrotech.domain.model.Treatment;
import com.agrotech.agrotech.domain.service.ITreatmentService;
import com.agrotech.agrotech.resource.SaveTreatmentResource;
import com.agrotech.agrotech.resource.TreatmentResource;
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

@Tag(name = "Treatments", description = "Treatments API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class TreatmentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ITreatmentService treatmentService;

    private TreatmentResource convertToResource(Treatment entity){
        return mapper.map(entity, TreatmentResource.class);
    }
    private Treatment convertToEntity(SaveTreatmentResource resource){
        return mapper.map(resource, Treatment.class);
    }

    @Operation(summary="Get All Treatments")
    @GetMapping("/treatments")
    public Page<TreatmentResource> getAllTreatments(Pageable pageable){
        Page<Treatment> treatmentPage = treatmentService.getAllTreatments(pageable);
        List<TreatmentResource> resources = treatmentPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get Treatment By Id")
    @GetMapping("/treatments/{treatmentId}")
    public TreatmentResource getTreatmentById(@PathVariable(value = "treatmentId") Long treatmentId){
        return convertToResource(treatmentService.getTreatmentById(treatmentId));
    }

    @Operation(summary="Create Treatment")
    @PostMapping("/treatments")
    public TreatmentResource createTreatment(@Valid @RequestBody SaveTreatmentResource resource){
        Treatment treatment = convertToEntity(resource);
        return convertToResource(treatmentService.createTreatment(treatment));
    }

    @Operation(summary="Update Treatment")
    @PutMapping("/treatments/{treatmentId}")
    public TreatmentResource updateTreatment(@PathVariable Long treatmentId, @Valid @RequestBody SaveTreatmentResource resource){
        Treatment treatment = convertToEntity(resource);
        return convertToResource(
                treatmentService.updateTreatment(treatmentId,treatment));

    }

    @Operation(summary="Delete Treatment")
    @DeleteMapping("/treatments/{treatmentId}")
    public ResponseEntity<?> deleteTreatment(@PathVariable Long treatmentId){
        return treatmentService.deleteTreatment(treatmentId);
    }
}
