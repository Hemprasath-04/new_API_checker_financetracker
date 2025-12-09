package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("budget_allocations")
public class BudgetAllocation {
    @Id
    private String id;
    private String userId;
    private String categoryId;
    private double amount; // monthly allocated amount

    public BudgetAllocation(){}
    // getters and setters
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}
    public String getCategoryId(){return categoryId;}
    public void setCategoryId(String categoryId){this.categoryId = categoryId;}
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
}
