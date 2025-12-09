package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.service.ProfileService;
import com.example.financetracker.model.Profile;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Profile getProfile(HttpServletRequest request){
        return profileService.getProfile((String) request.getAttribute("userId"));
    }

    @PutMapping
    public Object updateProfile(@RequestBody Profile p, HttpServletRequest request){
        return profileService.updateProfile((String) request.getAttribute("userId"), p);
    }
}
