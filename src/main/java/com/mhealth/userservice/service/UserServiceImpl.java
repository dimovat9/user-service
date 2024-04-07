package com.mhealth.userservice.service;
import com.mhealth.userservice.entity.AppUser;
import com.mhealth.userservice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public AppUser createUser(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public AppUser getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElse(null);
    }
    @Override
    public void saveUser(AppUser user) {
        userRepository.save(user);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }
}