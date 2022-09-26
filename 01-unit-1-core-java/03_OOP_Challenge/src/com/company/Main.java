package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Checking checkingAcct = new Checking("James Vongampai", "Jantira Vongampai", 20000.00);
        Savings savingsAccount = new Savings("z23f49f9", "James Vongampai", 20000.00);
        Loan autoLoanAccount = new Loan("l9fg48h8", "James Vongampai", 53002.29);
        System.out.println(checkingAcct);
        System.out.println(savingsAccount);
        System.out.println(autoLoanAccount);
        Date d = new Date(1546905600);
        System.out.println(d);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String formattedDate = df.format(d);

        System.out.println(formattedDate);

        Transaction t1 = new Transaction(Transaction.Type.DEPOSIT, 1546905600, "a23f49f9", 900);
        Transaction t2 = new Transaction(Transaction.Type.DEPOSIT, 1546805600, "a23f49f9", 900);
        Transaction t3 = new Transaction(Transaction.Type.DEPOSIT, 1546705600, "a23f49f9", 900);
        Transaction t4 = new Transaction(Transaction.Type.DEPOSIT, 1546605600, "a23f49f9", 900);
        Transaction t5 = new Transaction(Transaction.Type.DEPOSIT, 1546505600, "a23f49f9", 900);
        Transaction t6 = new Transaction(Transaction.Type.DEPOSIT, 1546405600, "a23f49f9", 900);
        ArrayList<Transaction> transactions = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6));
        System.out.println(transactions);
        Collections.sort(transactions);
        System.out.println("Sorted" + transactions);

        System.out.println(t1);
        System.out.println(t1.equals(t2));
    }
}
