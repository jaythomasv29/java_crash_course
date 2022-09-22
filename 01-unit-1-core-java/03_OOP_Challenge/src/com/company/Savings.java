package com.company;

public class Savings extends Account {
    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {

    }
    @Override
    public boolean withdraw(double amount) {
        return true;
    }
}
