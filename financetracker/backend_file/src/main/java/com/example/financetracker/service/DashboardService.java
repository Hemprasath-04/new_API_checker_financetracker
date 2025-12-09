package com.example.financetracker.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.repository.ExpenseRepository;
import com.example.financetracker.repository.BudgetAllocationRepository;
import com.example.financetracker.repository.SalaryRepository;
import com.example.financetracker.model.Expense;
import com.example.financetracker.model.BudgetAllocation;
import com.example.financetracker.model.Salary;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private BudgetAllocationRepository budgetRepo;

    @Autowired
    private SalaryRepository salaryRepo;

    public double getMonthlySpend(String userId) {
        YearMonth ym = YearMonth.now();
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        List<Expense> list = expenseRepository.findByUserIdAndDateBetween(userId, start, end);
        return list.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getMonthlyBudget(String userId) {
        List<BudgetAllocation> list = budgetRepo.findByUserId(userId);
        return list.stream().mapToDouble(BudgetAllocation::getAmount).sum();
    }

    public double getRemainingBudget(String userId) {
        double budget = getMonthlyBudget(userId);
        double spend = getMonthlySpend(userId);
        return budget - spend;
    }
}
