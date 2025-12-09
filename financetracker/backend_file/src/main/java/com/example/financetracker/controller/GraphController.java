package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.service.GraphService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard/graphs")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @GetMapping("/line")
    public Map<Integer, Double> getLine(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return graphService.getLineGraph(userId);
    }

    @GetMapping("/pie")
    public Map<String, Double> getPie(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return graphService.getPieChart(userId);
    }
}
