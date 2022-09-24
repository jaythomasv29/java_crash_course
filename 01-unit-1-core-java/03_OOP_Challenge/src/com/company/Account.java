package com.company;

import java.text.DecimalFormat;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);


    public Account(String id, String name, double balance) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid Params for Acct");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid Id");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

    @Override
    public String toString() {
        return ("*************ACCT INFO***************** \n" +  this.getClass().getSimpleName() + "\n Acct Id:" + id + "\n Acct Name: " + name + "\n Acct Balance: " + balance + "\n ******************************");
    }
}
