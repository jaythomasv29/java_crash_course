package com.company;

public class Chocolate extends Cupcake {
    public Chocolate(double price) {
        super(price);
    }

    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}
