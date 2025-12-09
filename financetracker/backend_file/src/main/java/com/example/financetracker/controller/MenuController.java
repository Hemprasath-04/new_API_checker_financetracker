package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.service.MenuService;
import com.example.financetracker.model.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Budget Allocation
    @GetMapping("/budget")
    public List<BudgetAllocation> getBudgets(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return menuService.getBudgets(userId);
    }

    @PostMapping("/budget")
    public BudgetAllocation createBudget(@RequestBody BudgetAllocation b, HttpServletRequest request){
        b.setUserId((String) request.getAttribute("userId"));
        return menuService.createBudget(b);
    }

    @PutMapping("/budget")
    public BudgetAllocation updateBudget(@RequestBody BudgetAllocation b, HttpServletRequest request){
        b.setUserId((String) request.getAttribute("userId"));
        return menuService.updateBudget(b);
    }

    @DeleteMapping("/budget/{id}")
    public void deleteBudget(@PathVariable String id){
        menuService.deleteBudget(id);
    }

    // Savings
    @GetMapping("/savings")
    public List<Saving> getSavings(HttpServletRequest request){
        return menuService.getSavings((String) request.getAttribute("userId"));
    }

    @PostMapping("/savings")
    public Saving createSaving(@RequestBody Saving s, HttpServletRequest request){
        s.setUserId((String) request.getAttribute("userId"));
        return menuService.createSaving(s);
    }

    // Salary
    @GetMapping("/salary")
    public Salary getSalary(HttpServletRequest request){
        return menuService.getSalary((String) request.getAttribute("userId"));
    }

    @PostMapping("/salary")
    public Salary setSalary(@RequestBody Salary s, HttpServletRequest request){
        s.setUserId((String) request.getAttribute("userId"));
        return menuService.setSalary(s);
    }

    // Expense
    @PostMapping("/expense")
    public Expense addExpense(@RequestBody Expense e, HttpServletRequest request){
        e.setUserId((String) request.getAttribute("userId"));
        return menuService.addExpense(e);
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses(HttpServletRequest request){
        return menuService.getExpenses((String) request.getAttribute("userId"));
    }

    // Category
    @PostMapping("/category")
    public Category addCategory(@RequestBody Category c, HttpServletRequest request){
        c.setUserId((String) request.getAttribute("userId"));
        return menuService.addCategory(c);
    }

    @GetMapping("/categories")
    public List<Category> getCategories(HttpServletRequest request){
        return menuService.getCategories((String) request.getAttribute("userId"));
    }

    // Account
    @PostMapping("/account")
    public Account addAccount(@RequestBody Account a, HttpServletRequest request){
        a.setUserId((String) request.getAttribute("userId"));
        return menuService.addAccount(a);
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(HttpServletRequest request){
        return menuService.getAccounts((String) request.getAttribute("userId"));
    }
}
