package com.babylon.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String first_name;
    private final String last_name;
    private final String d_o_b;
    private final String gender;
    private final String university_email;
    private final String university_name;
    private final String program;
    private final String password;
    private final String nationality;
    private final String dietary;
    private final String language;
    private final String shared_occupancy;

    // 0/1 value
    private final String pet_preference;

    // 0/1/2 value
    private final String smoking_habit;

    // 0/1/2 value
    private final String drinking_habit;


    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("first_name") String first_name,
                  @JsonProperty("last_name") String last_name,
                  @JsonProperty("d_o_b") String d_o_b,
                  @JsonProperty("gender") String gender,
                  @JsonProperty("university_email") String university_email,
                  @JsonProperty("university_name") String university_name,
                  @JsonProperty("program") String program,
                  @JsonProperty("password") String password,
                  @JsonProperty("nationality") String nationality,
                  @JsonProperty("dietary") String dietary,
                  @JsonProperty("language") String language,
                  @JsonProperty("shared_occupancy") String shared_occupancy,
                  @JsonProperty("pet_preference") String pet_preference,
                  @JsonProperty("smoking_habit") String smoking_habit,
                  @JsonProperty("drinking_habit") String drinking_habit){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.d_o_b = d_o_b;
        this.gender = gender;
        this.university_email = university_email;
        this.program = program;
        this.password = password;
        this.nationality = nationality;
        this.dietary = dietary;
        this.language = language;
        this.shared_occupancy = shared_occupancy;
        this.pet_preference = pet_preference;
        this.smoking_habit = smoking_habit;
        this.drinking_habit = drinking_habit;
        this.university_name = university_name;
    }

    public UUID getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getD_o_b() {
        return d_o_b;
    }

    public String getGender() {
        return gender;
    }

    public String getUniversity_email() {
        return university_email;
    }

    public String getProgram() {
        return program;
    }

    public String getPassword() {
        return password;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDietary() {
        return dietary;
    }

    public String getLanguage() {
        return language;
    }

    public String getShared_occupancy() {
        return shared_occupancy;
    }

    public String getPet_preference() {
        return pet_preference;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public String getSmoking_habit() {
        return smoking_habit;
    }

    public String getDrinking_habit() {
        return drinking_habit;
    }
}
