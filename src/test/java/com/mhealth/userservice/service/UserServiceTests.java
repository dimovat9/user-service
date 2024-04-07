package com.mhealth.userservice.service;

import com.mhealth.userservice.entity.AppUser;
import com.mhealth.userservice.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class UserServiceTests {

    @Mock
    private AppUserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @SuppressWarnings("resource")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById() {
        // Arrange
        long userId = 1L;
        AppUser user = new AppUser();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        AppUser result = userService.getUserById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
    }

    @Test
    void testCreateUser() {
        // Arrange
        AppUser user = new AppUser();
        when(userRepository.save(any(AppUser.class))).thenReturn(user);

        // Act
        AppUser createdUser = userService.createUser(user);

        // Assert
        assertNotNull(createdUser);
        // Add more specific assertions if needed
    }

    @Test
    void testDeleteUser() {
        // Arrange
        long userId = 1L;

        // Act
        userService.deleteUser(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
        // Add more assertions as needed
    }
}