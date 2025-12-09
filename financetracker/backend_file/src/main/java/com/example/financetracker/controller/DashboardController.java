package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.service.DashboardService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/cards")
    public Map<String, Object> getCards(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        map.put("monthlySpend", dashboardService.getMonthlySpend(userId));
        map.put("monthlyBudget", dashboardService.getMonthlyBudget(userId));
        map.put("remainingBudget", dashboardService.getRemainingBudget(userId));
        return map;
    }
}
