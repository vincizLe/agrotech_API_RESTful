package com.agrotech.agrotech.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="chilies")
public class Chili {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public Chili setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Chili setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Chili setDescription(String description) {
        this.description = description;
        return this;
    }
}
