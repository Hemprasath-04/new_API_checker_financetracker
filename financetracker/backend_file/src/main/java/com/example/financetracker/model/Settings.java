package com.example.financetracker.model;

public class Settings {
    private boolean notificationsEnabled = true;
    private String currency = "INR";

    public Settings(){}
    // getters setters
    public boolean isNotificationsEnabled(){return notificationsEnabled;}
    public void setNotificationsEnabled(boolean notificationsEnabled){this.notificationsEnabled = notificationsEnabled;}
    public String getCurrency(){return currency;}
    public void setCurrency(String currency){this.currency = currency;}
}
