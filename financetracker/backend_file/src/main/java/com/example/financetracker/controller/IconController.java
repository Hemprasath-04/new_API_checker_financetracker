package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("/api/dashboard/icons")
public class IconController {

    @GetMapping
    public Map<String, Object> getIcons() {
        Map<String,Object> map = new HashMap<>();
        map.put("icons", Arrays.asList("notification", "profile", "settings"));
        return map;
    }
}
