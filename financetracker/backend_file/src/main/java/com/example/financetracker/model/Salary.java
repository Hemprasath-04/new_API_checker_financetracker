package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("salaries")
public class Salary {
    @Id
    private String id;
    private String userId;
    private double monthlySalary;

    public Salary(){}
    // getters and setters
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}
    public double getMonthlySalary(){return monthlySalary;}
    public void setMonthlySalary(double monthlySalary){this.monthlySalary = monthlySalary;}
}
