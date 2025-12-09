package com.example.financetracker.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.repository.*;
import com.example.financetracker.model.*;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private BudgetAllocationRepository budgetRepo;
    @Autowired
    private SavingRepository savingRepo;
    @Autowired
    private SalaryRepository salaryRepo;
    @Autowired
    private ExpenseRepository expenseRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private AccountRepository accountRepo;

    // Budget allocation CRUD
    public BudgetAllocation createBudget(BudgetAllocation b){ return budgetRepo.save(b); }
    public BudgetAllocation updateBudget(BudgetAllocation b){ return budgetRepo.save(b); }
    public void deleteBudget(String id){ budgetRepo.deleteById(id); }
    public List<BudgetAllocation> getBudgets(String userId){ return budgetRepo.findByUserId(userId); }

    // Savings
    public Saving createSaving(Saving s){ return savingRepo.save(s); }
    public List<Saving> getSavings(String userId){ return savingRepo.findByUserId(userId); }

    // Salary
    public Salary getSalary(String userId){ return salaryRepo.findByUserId(userId); }
    public Salary setSalary(Salary s){ return salaryRepo.save(s); }

    // Expense
    public Expense addExpense(Expense e){ return expenseRepo.save(e); }
    public List<Expense> getExpenses(String userId){ return expenseRepo.findByUserId(userId); }

    // Category
    public Category addCategory(Category c){ return categoryRepo.save(c); }
    public List<Category> getCategories(String userId){ return categoryRepo.findByUserId(userId); }

    // Account
    public Account addAccount(Account a){ return accountRepo.save(a); }
    public List<Account> getAccounts(String userId){ return accountRepo.findByUserId(userId); }
}
