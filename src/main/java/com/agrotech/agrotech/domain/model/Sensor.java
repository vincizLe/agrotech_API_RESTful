package com.agrotech.agrotech.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private int usefulLife;

    public Long getId() {
        return id;
    }

    public Sensor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sensor setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Sensor setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Sensor setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getUsefulLife() {
        return usefulLife;
    }

    public Sensor setUsefulLife(int usefulLife) {
        this.usefulLife = usefulLife;
        return this;
    }
}
