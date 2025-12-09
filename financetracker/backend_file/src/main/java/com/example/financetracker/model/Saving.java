package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("savings")
public class Saving {
    @Id
    private String id;
    private String userId;
    private double amount;
    private String note;

    public Saving(){}
    // getters and setters
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
    public String getNote(){return note;}
    public void setNote(String note){this.note = note;}
}
