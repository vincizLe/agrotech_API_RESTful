package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePlotTreatmentResource {
    @NotNull
    private String recipe;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    //Getters and Setters
    public String getRecipe() {
        return recipe;
    }

    public SavePlotTreatmentResource setRecipe(String recipe) {
        this.recipe = recipe;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SavePlotTreatmentResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SavePlotTreatmentResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
