package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class TreatmentResource {
    private Long id;

    private String type;

    private String description;

    private String certification;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public TreatmentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TreatmentResource setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TreatmentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCertification() {
        return certification;
    }

    public TreatmentResource setCertification(String certification) {
        this.certification = certification;
        return this;
    }
}
