package com.agrotech.agrotech.resource;

public class UserResource {
    private Long id;

    private String name;

    private String lastname;

    private Long dni;

    private Long cellphoneNumber;

    private String email;

    private String password;

    private String profileImage;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public UserResource setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public Long getCellphoneNumber() {
        return cellphoneNumber;
    }

    public UserResource setCellphoneNumber(Long cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public UserResource setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

}
