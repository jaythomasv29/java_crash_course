package com.company;

public class Cupcake {
    public double price;

    public Cupcake(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting.");
    }

    @Override
    public String toString() {
        return "Cupcake{" +
                "price=" + price +
                '}';
    }
}

