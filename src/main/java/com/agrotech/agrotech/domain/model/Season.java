package com.agrotech.agrotech.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public Season setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Season setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Season setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Season setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
