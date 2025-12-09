package com.example.financetracker.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.repository.UserRepository;
import com.example.financetracker.model.User;
import com.example.financetracker.model.Settings;

@Service
public class SettingsService {

    @Autowired
    private UserRepository userRepository;

    public Settings getSettings(String userId) {
        User u = userRepository.findById(userId).orElse(null);
        return u == null ? null : u.getSettings();
    }

    public User updateSettings(String userId, Settings s) {
        User u = userRepository.findById(userId).orElse(null);
        if (u == null) return null;
        u.setSettings(s);
        return userRepository.save(u);
    }
}
