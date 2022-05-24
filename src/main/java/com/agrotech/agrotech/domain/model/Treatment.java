package com.agrotech.agrotech.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="treatments")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private String certification;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public Treatment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Treatment setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Treatment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCertification() {
        return certification;
    }

    public Treatment setCertification(String certification) {
        this.certification = certification;
        return this;
    }
}
