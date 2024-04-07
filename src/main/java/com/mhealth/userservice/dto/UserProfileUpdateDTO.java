package com.mhealth.userservice.dto;

import java.util.HashSet;
import java.util.Set;

public class UserProfileUpdateDTO {

    private Integer age;
    private String gender;
    private Double weight;
    private Double height;
    private String activityLevel;
    private Set<String> dietaryPreferences = new HashSet<>();
    private Set<String> fitnessGoals = new HashSet<>();

    public UserProfileUpdateDTO() {
        // Initialize dietaryPreferences and fitnessGoals to empty sets
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Set<String> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(Set<String> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public Set<String> getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(Set<String> fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }
}
