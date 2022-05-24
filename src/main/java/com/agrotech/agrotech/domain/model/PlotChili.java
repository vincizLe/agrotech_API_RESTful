package com.agrotech.agrotech.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "plot_chilies")
public class PlotChili {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String location;

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
    @JoinColumn(name="chili_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Chili chili;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotChili setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PlotChili setLocation(String location) {
        this.location = location;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlotChili setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlotChili setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Plot getPlot() {
        return plot;
    }

    public PlotChili setPlot(Plot plot) {
        this.plot = plot;
        return this;
    }

    public Chili getChili() {
        return chili;
    }

    public PlotChili setChili(Chili chili) {
        this.chili = chili;
        return this;
    }
}
