package com.example.cars4sale.DataGenerator;

public class Car {
    private int id;
    private int coding;
    private String name;
    private String location;
    private int price;
    private int year;

    public Car(int id, int coding, String name, String location, int price, int year) {
        this.id = id;
        this.coding = coding;
        this.name = name;
        this.location = location;
        this.price = price;
        this.year = year;
    }

    public String getname() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoding() {
        return coding;
    }

    public void setCoding(int coding) {
        this.coding = coding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", coding=" + coding +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }

}
