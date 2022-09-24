package com.company;

public class Loan extends Account {
    private static final double INTEREST_RATE = 0.02;

    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Loan source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        // Loan Deposit -> Increases the amount of the loan when asking for more money
        super.setBalance(super.round(super.getBalance() + amount));

    }
    @Override
    public boolean withdraw(double amount) {
        super.setBalance(super.round(super.getBalance() - amount - (amount * INTEREST_RATE)));
        return true;
    }
}
