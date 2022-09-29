package unit_testing;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Double> prices = new ArrayList<>(Arrays.asList(1.2, 10.5, 4.2, 1.9, 6.9, 2.7, 9.3));
    static final double TAX_RATE = 13.0;


    public static void main(String[] args) {

//        List<Double> filteredPrices = prices.stream()
//                .filter((price)-> price > 2)
//                .collect(Collectors.toList());
//        System.out.println(filteredPrices);
        System.out.println(filterLowPrices());

        Movie m1 = new Movie("Wardogs", "DVD", 10.0);

    }

    public static double getSubtotalAmount() {
        double total = 0.0;
        for(double n : prices) {
            total += n;
        }
        return total;
    }

    public static double getTax(double subTotal) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(subTotal * (TAX_RATE / 100)));

    }

    public static double getTotal(double subTotal) {
        DecimalFormat df = new DecimalFormat("#.##");
        return (subTotal + getTax(subTotal));
    }
    public static List<Double> filterLowPrices() {
        return prices.stream()
                .filter((price)-> price > 2)
                .collect(Collectors.toList());

    }

}
