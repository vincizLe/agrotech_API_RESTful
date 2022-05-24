package com.agrotech.agrotech.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePlotPlagueResource {
    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String damage;

    //Getters and Setters
    public Date getStartDate() {
        return startDate;
    }

    public SavePlotPlagueResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SavePlotPlagueResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDamage() {
        return damage;
    }

    public SavePlotPlagueResource setDamage(String damage) {
        this.damage = damage;
        return this;
    }
}
