package org.example.exercise.entities;

public class Product {

    private String naem;
    private double price;

    public Product(String naem, double price) {
        this.naem = naem;
        this.price = price;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "naem='" + naem + '\'' +
                ", price=" + price +
                '}';
    }
}
