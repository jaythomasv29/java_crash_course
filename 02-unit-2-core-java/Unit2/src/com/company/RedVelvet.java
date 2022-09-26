package com.company;

public class RedVelvet extends Cupcake {
    public RedVelvet(double price) {
        super(price);
    }

    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}
