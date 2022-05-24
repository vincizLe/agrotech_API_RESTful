package com.agrotech.agrotech.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "plot_treatments")
public class PlotTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String recipe;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="plot_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plot plot;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="treatment_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Treatment treatment;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotTreatment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRecipe() {
        return recipe;
    }

    public PlotTreatment setRecipe(String recipe) {
        this.recipe = recipe;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlotTreatment setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlotTreatment setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Plot getPlot() {
        return plot;
    }

    public PlotTreatment setPlot(Plot plot) {
        this.plot = plot;
        return this;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public PlotTreatment setTreatment(Treatment treatment) {
        this.treatment = treatment;
        return this;
    }
}
