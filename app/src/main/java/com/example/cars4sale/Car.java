package com.example.cars4sale;

public class Car {
    private int id;
    private int coding;
    private String carname;
    private String location;
    private int price;
    private int year;

    public Car(int id,int coding, String carname, String location, int price,int year)
    {
        this.id = id;
        this.coding = coding;
        this.carname = carname;
        this.location = location;
        this.price = price;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcoding() {
        return coding;
    }

    public void setcoding(int id) {
        this.coding = coding;
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

    public int getyear(){
        return year;
    }

    public void setyear(int price){
        this.year = year;
    }


    //public String toString()
    //{
     //   return "id: " + this.id + " - Carname: " + this.carname + " - Location: " + this.location + "- Price: " + this.price ;
   // }
}
