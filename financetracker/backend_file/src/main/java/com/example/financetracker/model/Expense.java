package com.example.financetracker.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("expenses")
public class Expense {
    @Id
    private String id;
    private String userId;
    private String categoryId;
    private String accountId;
    private double amount;
    private LocalDate date;
    private String notes;

    public Expense() {}

    // getters and setters
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}
    public String getCategoryId(){return categoryId;}
    public void setCategoryId(String categoryId){this.categoryId = categoryId;}
    public String getAccountId(){return accountId;}
    public void setAccountId(String accountId){this.accountId = accountId;}
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date = date;}
    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes = notes;}
}
