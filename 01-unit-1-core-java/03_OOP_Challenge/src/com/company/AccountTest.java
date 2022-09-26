package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account[] accounts;

    @BeforeEach
    void setup() {
        accounts = new Account[] {
                new Checking("a23f49f9", "Jantira Vongampai", 20000.00),
                new Savings("z23f49f9", "James Vongampai", 20000.00),
                new Loan("l9fg48h8", "James Vongampai", 53002.29)
        };
    }

    @Test
    public void withdraw() {
        // A checking account allows for withdrawal and updates current balance accordingly
        accounts[0].withdraw(2000);
        assertEquals(18000, accounts[0].getBalance());
    }

    @Test
    public void overdraft() {
        // The checking account charges an overdraft fee of $5.50 if the withdrawal amount exceeds balance but less than overdraft limit
        accounts[0].withdraw(20100);
        assertEquals(-105.50, accounts[0].getBalance());
    }

    @Test
    public void overdraftLimit() {
        // overdraft limit is $200.00 dollars
        // You cannot withdraw more than $200 over your current balance
        accounts[0].withdraw(20201.00);
        assertEquals(20000.00, accounts[0].getBalance());
    }

    @Test
    public void savingsWithdrawalFee() {
        // Deposits are free, but savings accounts charge a $5.00 fee for ever withdrawal
        accounts[1].withdraw(100.00);
        assertEquals(19895.00, accounts[1].getBalance());
    }

    @Test
    public void loanWithdrawalWithInterest() {
        // Every loan account withdrawal is charged with a fixed interest rate of 2%
        accounts[2].withdraw(2000);
        assertEquals(50962.29, accounts[2].getBalance());
    }

    @Test
    public void depositIntoChecking() {
        accounts[0].deposit(10000.50);
        assertEquals(30000.50, accounts[0].getBalance());
    }

    @Test
    public void depositIntoSavings() {
        accounts[1].deposit(10000.50);
        assertEquals(30000.50, accounts[1].getBalance());
    }

    @Test
    public void loanDeposit() {
        accounts[2].deposit(1000);
        assertEquals(54002.29, accounts[2].getBalance());
    }

    @Test
    public void incomeTax() {
        double amount = 4000;
        accounts[0].deposit(amount);
        ((Checking) accounts[0]).tax(4000);
        assertEquals(23400, accounts[0].getBalance());

    }
}

