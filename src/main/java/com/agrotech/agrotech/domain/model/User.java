package com.agrotech.agrotech.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private Long dni;

    @NotNull
    private Long cellphoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String profileImage;

    @NotNull
    private Boolean accessType;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public User setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public Long getCellphoneNumber() {
        return cellphoneNumber;
    }

    public User setCellphoneNumber(Long cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public User setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public Boolean getAccessType() {
        return accessType;
    }

    public User setAccessType(Boolean accessType) {
        this.accessType = accessType;
        return this;
    }
}
