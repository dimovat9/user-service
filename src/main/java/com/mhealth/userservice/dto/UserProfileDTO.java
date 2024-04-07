package com.mhealth.userservice.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

public class UserProfileDTO {

    @NotNull(message = "User ID is required")
    private long userId;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be a positive number")
    private Integer age;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be a positive number")
    private Double weight;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be a positive number")
    private Double height;

    @NotBlank(message = "Activity level is required")
    private String activityLevel;

    @NotEmpty(message = "At least one dietary preference must be selected")
    private Set<String> dietaryPreferences;

    @NotEmpty(message = "At least one fitness goal must be selected")
    private Set<String> fitnessGoals;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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