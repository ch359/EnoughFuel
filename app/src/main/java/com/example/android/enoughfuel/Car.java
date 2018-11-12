package com.example.android.enoughfuel;

/**
 * Created by ragnar on 09/11/2018.
 */
public class Car {

    private String name;
    private double fuelTankCapacityInGallons;
    private double mpg;

    public Car(double capacity) {
        fuelTankCapacityInGallons = capacity;
        this.name = "Nissan Micra"; //todo car profiles not implemented yet
        this.mpg = 30; //todo choice of mileage units

    }

    public String getName() {
        return name;
    }

    public double getFuelTankCapacityInGallons() {
        return fuelTankCapacityInGallons;
    }

    public double getMpg() {
        return mpg;
    }
}
