package com.company;

public class Checking extends Account implements Taxable {
    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = -200.00;
    private static final double INCOME_TAX_RATE = 0.15;

     public Checking(String id, String name, double balance) {
         super(id, name, balance);
     }

     public Checking(Checking source) {
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
    public boolean withdraw(double amount){
         if(super.getBalance() - amount < OVERDRAFT_LIMIT) {
             System.out.println("Insufficient funds");
             return false;
         } else if (super.getBalance() - amount < 0 && super.getBalance() - amount > OVERDRAFT_LIMIT){
                 super.setBalance(super.getBalance() - amount - OVERDRAFT_FEE);
                 System.out.println("Overdraft fee charged, your withdrawal exceeded your account balance");
                 System.out.println("Balance: " + super.getBalance());
         } else {
             super.setBalance(super.getBalance() - amount);
         }
        return true;
    }

    @Override
    public void tax(double income) {
         if (income > 3000) {
             double taxAmount = super.round(income * INCOME_TAX_RATE);
             System.out.println(taxAmount);
             super.setBalance(super.getBalance() - taxAmount);
             System.out.println("Your income deposit of " + income + " was over 3000 and was therefore charged a rate of " + "\n " + INCOME_TAX_RATE * 100 + "% \n" + "total: " + taxAmount);
         }

    }

}
