package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTests {
    Transaction transaction;
    @BeforeEach
    public void setup() {
        transaction = new Transaction(Transaction.Type.DEPOSIT, 1664073008, "a23f49f9", 900);

    }

    @Test
    public void timestampAsDate() {
        String actual = transaction.convertTimestamp();
        System.out.println(actual);
        assertEquals("24-09-2022", actual);
    }

}