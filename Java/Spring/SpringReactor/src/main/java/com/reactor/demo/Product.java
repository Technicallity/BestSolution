package com.reactor.demo;


public class Product {
    int id;
    String name;
    int price;
    double value;

    public Product() {    }

    public Product(int id, String name, int price, double value) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", value=" + value +
                '}';
    }
}
