package com.example.financetracker.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.repository.UserRepository;
import com.example.financetracker.model.User;
import com.example.financetracker.model.Profile;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public Profile getProfile(String userId) {
        User u = userRepository.findById(userId).orElse(null);
        return u == null ? null : u.getProfile();
    }

    public User updateProfile(String userId, Profile p) {
        User u = userRepository.findById(userId).orElse(null);
        if (u == null) return null;
        u.setProfile(p);
        return userRepository.save(u);
    }
}
