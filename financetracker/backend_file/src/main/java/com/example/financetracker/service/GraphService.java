package com.example.financetracker.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.repository.ExpenseRepository;
import com.example.financetracker.model.Expense;
import java.time.YearMonth;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

@Service
public class GraphService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Return line graph data: map of day -> total expense for current month
    public Map<Integer, Double> getLineGraph(String userId) {
        YearMonth ym = YearMonth.now();
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        List<Expense> list = expenseRepository.findByUserIdAndDateBetween(userId, start, end);
        Map<Integer, Double> map = new TreeMap<>();
        for (Expense e: list) {
            int day = e.getDate().getDayOfMonth();
            map.put(day, map.getOrDefault(day, 0.0) + e.getAmount());
        }
        return map;
    }

    // Return pie data: categoryId -> total amount for current month
    public Map<String, Double> getPieChart(String userId) {
        YearMonth ym = YearMonth.now();
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        List<Expense> list = expenseRepository.findByUserIdAndDateBetween(userId, start, end);
        Map<String, Double> map = new HashMap<>();
        for (Expense e: list) {
            String cat = e.getCategoryId() == null ? "uncategorized" : e.getCategoryId();
            map.put(cat, map.getOrDefault(cat, 0.0) + e.getAmount());
        }
        return map;
    }
}
