package com.company;

public class Savings extends Account {
    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source);
    }

    @Override
    public void deposit(double amount){
        if(amount > 0) {
            System.out.println(super.getBalance() + amount);
            super.setBalance(super.getBalance() + amount);
            System.out.println("Deposit successful" + super.toString());
        }

    }
    @Override
    public boolean withdraw(double amount) {
        if(super.getBalance() - amount < 0) {
            return false;
        }
        super.setBalance(super.getBalance() - amount - WITHDRAWAL_FEE);
        return true;
    }
}
