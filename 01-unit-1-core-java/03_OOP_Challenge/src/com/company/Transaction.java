package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
    public enum Type {WITHDRAW, DEPOSIT};
    private Type type;
    private long timestamp;
    private String id;
    private double amount;

    public Transaction(Type type, long timestamp, String id, double amount) {
        if (id == null || id.isBlank() || amount < 0) {
            throw new IllegalArgumentException("Invalid Params for Transaction");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source) {
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid Id");
        }
        this.id = id;
    }

    public double getAmount() {
        if(amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String convertTimestamp() {
        Date d = new Date(timestamp * 1000);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(d);
        return formattedDate;
    }

    public boolean equals(Transaction t) {
        return Objects.equals(type, t.type) && timestamp == t.timestamp && Objects.equals(id, t.id) && amount == t.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public String toString() {
        return (type) + "    " +
                "\t" + convertTimestamp() + "" +
                "\t" + id + "" +
                "\t$" + amount + "";
    }
    @Override
    public int compareTo(Transaction t) {
        if(t.timestamp > t.timestamp) {
            return -1;
        } else if(t.timestamp == t.timestamp) {
            return 0;
        } else {
            return 1;
        }
    }
}
