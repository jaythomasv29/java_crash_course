package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Checking checkingAcct = new Checking("James Vongampai", "Jantira Vongampai", 20000.00);
        checkingAcct.setName("");
        Savings savingsAccount = new Savings("z23f49f9", "James Vongampai", 20000.00);
        Loan autoLoanAccount = new Loan("l9fg48h8", "James Vongampai", 53002.29);
        System.out.println(checkingAcct);
        System.out.println(savingsAccount);
        System.out.println(autoLoanAccount);
    }
}
