package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.service.SettingsService;
import com.example.financetracker.model.Settings;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping
    public Settings getSettings(HttpServletRequest request){
        return settingsService.getSettings((String) request.getAttribute("userId"));
    }

    @PutMapping
    public Object updateSettings(@RequestBody Settings s, HttpServletRequest request){
        return settingsService.updateSettings((String) request.getAttribute("userId"), s);
    }
}
