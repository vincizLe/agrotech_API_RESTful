package com.agrotech.agrotech.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "plot_plagues")
public class PlotPlague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String damage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="plot_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plot plot;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="plague_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plague plague;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public PlotPlague setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public PlotPlague setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public PlotPlague setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDamage() {
        return damage;
    }

    public PlotPlague setDamage(String damage) {
        this.damage = damage;
        return this;
    }

    public Plot getPlot() {
        return plot;
    }

    public PlotPlague setPlot(Plot plot) {
        this.plot = plot;
        return this;
    }

    public Plague getPlague() {
        return plague;
    }

    public PlotPlague setPlague(Plague plague) {
        this.plague = plague;
        return this;
    }
}
