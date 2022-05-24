package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;

public class SaveTreatmentResource {
    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private String certification;

    //Getters and Setters
    public String getType() {
        return type;
    }

    public SaveTreatmentResource setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveTreatmentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCertification() {
        return certification;
    }

    public SaveTreatmentResource setCertification(String certification) {
        this.certification = certification;
        return this;
    }
}
