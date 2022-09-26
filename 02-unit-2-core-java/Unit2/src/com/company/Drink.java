package com.company;

public class Drink {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A bottle of water");
    }

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                '}';
    }
}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of soda");
    }
}

class Milk extends Drink {

    @Override
    public void type() {
        System.out.println("A bottle of milk");
    }
}
