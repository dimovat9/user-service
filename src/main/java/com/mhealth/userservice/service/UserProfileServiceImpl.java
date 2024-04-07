package com.mhealth.userservice.service;

import com.mhealth.userservice.entity.UserProfile;
import com.mhealth.userservice.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getUserProfileById(Long userProfileId) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(userProfileId);
        return userProfileOptional.orElse(null);
    }


    @Override
    public UserProfile updateUserProfile(UserProfile userProfile) {
        // Ensure the user profile has a non-null ID
        if (userProfile.getId() == null) {
            throw new IllegalArgumentException("User profile ID cannot be null");
        }

        // Get the existing user profile from the database
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(userProfile.getId());
        if (userProfileOptional.isPresent()) {
            UserProfile existingProfile = userProfileOptional.get();

            // Update only the fields that are not null in the provided user profile
            if (userProfile.getAge() != null) {
                existingProfile.setAge(userProfile.getAge());
            }
            if (userProfile.getGender() != null) {
                existingProfile.setGender(userProfile.getGender());
            }
            if (userProfile.getWeight() != null) {
                existingProfile.setWeight(userProfile.getWeight());
            }
            if (userProfile.getHeight() != null) {
                existingProfile.setHeight(userProfile.getHeight());
            }
            if (userProfile.getActivityLevel() != null) {
                existingProfile.setActivityLevel(userProfile.getActivityLevel());
            }
            if (userProfile.getDietaryPreferences() != null) {
                existingProfile.setDietaryPreferences(userProfile.getDietaryPreferences());
            }
            if (userProfile.getFitnessGoals() != null) {
                existingProfile.setFitnessGoals(userProfile.getFitnessGoals());
            }

            // Save the updated user profile
            return userProfileRepository.save(existingProfile);
        } else {
            // Handle the case where the user profile does not exist
            throw new IllegalArgumentException("User profile with ID " + userProfile.getId() + " does not exist");
        }
    }


    @Override
    public void deleteUserProfile(Long userProfileId) {
        userProfileRepository.deleteById(userProfileId);
    }


}
