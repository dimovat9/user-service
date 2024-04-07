package com.mhealth.userservice.service;
import com.mhealth.userservice.entity.AppUser;

import java.util.List;

public interface UserService {
    AppUser createUser(AppUser user);
    AppUser getUserById(Long userId);
    void saveUser(AppUser user);
    void deleteUser(Long userId);
    List<AppUser> getAllUsers(); // New method to retrieve all users
}