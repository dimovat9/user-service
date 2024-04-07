package com.mhealth.userservice.service;

import com.mhealth.userservice.entity.UserProfile;
import com.mhealth.userservice.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserProfileServiceTests {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;


    @SuppressWarnings("resource")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUserProfile() {
        // Arrange
        UserProfile userProfile = createUserProfile();
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(userProfile);

        // Act
        UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);

        // Assert
        assertNotNull(createdUserProfile);
        assertEquals(userProfile.getUserId(), createdUserProfile.getUserId());
        assertEquals(userProfile.getAge(), createdUserProfile.getAge());
        // Add more assertions as needed
    }

    @Test
    void testGetUserProfileById() {
        // Arrange
        long userId = 1L;
        UserProfile userProfile = createUserProfile();
        userProfile.setId(userId);
        when(userProfileRepository.findById(userId)).thenReturn(Optional.of(userProfile));

        // Act
        UserProfile result = userProfileService.getUserProfileById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals(userProfile.getUserId(), result.getUserId());
        assertEquals(userProfile.getAge(), result.getAge());
        // Add more assertions as needed
    }

    @Test
    void testUpdateUserProfile() {
        // Arrange
        long userId = 1L; // ID of the user profile to be updated
        UserProfile userProfile = createUpdatedUserProfile();
        userProfile.setId(userId); // Set the ID for the user profile
        when(userProfileRepository.findById(userId)).thenReturn(Optional.of(userProfile));
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(userProfile);

        // Act
        UserProfile updatedUserProfile = userProfileService.updateUserProfile(userProfile);

        // Assert
        assertNotNull(updatedUserProfile);
        assertEquals(userProfile.getUserId(), updatedUserProfile.getUserId());
        assertEquals(userProfile.getAge(), updatedUserProfile.getAge());
        // Add more assertions as needed
    }

    @Test
    void testDeleteUserProfile() {
        // Arrange
        long userId = 1L;

        // Act
        userProfileService.deleteUserProfile(userId);

        // Assert
        verify(userProfileRepository, times(1)).deleteById(userId);
    }

    private UserProfile createUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(123L);
        userProfile.setAge(30);
        // Set other properties as needed
        return userProfile;
    }

    private UserProfile createUpdatedUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(123L);
        userProfile.setAge(35); // Update the age for testing purposes
        // Set other properties as needed
        return userProfile;
    }
}
