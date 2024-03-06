package org.example.predicate.util;

import org.example.predicate.entities.Product;

import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {
    @Override
    public boolean test(Product product) {
        return product.getPrice()  >= 500.0;
    }
}
