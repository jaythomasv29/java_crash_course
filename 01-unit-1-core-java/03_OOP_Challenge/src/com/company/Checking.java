package com.company;

public class Checking extends Account {

     public Checking(String id, String name, double balance) {
         super(id, name, balance);
     }

     public Checking(Checking source) {
         super(source);
     }

     @Override
    public void deposit(double amount){}

    @Override
    public boolean withdraw(double amount){
         return true;
    }
}
