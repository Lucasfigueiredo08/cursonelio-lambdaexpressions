package org.example.predicate.application;

import org.example.predicate.entities.Product;
import org.example.predicate.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        double min = 100.0;

        Predicate<Product> pred = p -> p.getPrice() >= min;
        list.removeIf(pred);

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Mouse", 30.50));
        list.add(new Product("HD Case", 80.90));

        list.removeIf(pred);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
