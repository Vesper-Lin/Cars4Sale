package com.example.cars4sale;

public class Car {
    private int id;
    private String carname;
    private String location;
    private int price;

    public Car(int id, String carname, String location, int price)
    {
        this.id = id;
        this.carname = carname;
        this.location = location;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcarname() {
        return carname;
    }

    public void setcarname(String carname) {
        this.carname = carname;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "id: " + this.id + " - Carname: " + this.carname + " - Location: " + this.location + "- Price: " + this.price ;
    }
}
