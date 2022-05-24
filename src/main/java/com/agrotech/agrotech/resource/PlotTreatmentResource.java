package com.agrotech.agrotech.resource;

import com.agrotech.agrotech.domain.model.Plot;
import com.agrotech.agrotech.domain.model.Treatment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PlotTreatmentResource {
    private Long id;

    private String recipe;

    private Date startDate;

    private Date endDate;

    private Long plotId;

    private Long treatmentId;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotTreatmentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRecipe() {
        return recipe;
    }

    public PlotTreatmentResource setRecipe(String recipe) {
        this.recipe = recipe;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlotTreatmentResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlotTreatmentResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Long getPlotId() {
        return plotId;
    }

    public PlotTreatmentResource setPlotId(Long plotId) {
        this.plotId = plotId;
        return this;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public PlotTreatmentResource setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
        return this;
    }
}
