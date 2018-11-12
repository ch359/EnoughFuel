package com.example.android.enoughfuel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ragnar on 09/11/2018.
 */
public class Car {

    private String name;
    private double capacity;
    private String units;
    private double fuelTankCapacityInGallons;

    private double mpg;

    public Car(double capacity, String units) {
        fuelTankCapacityInGallons = capacity;
        this.capacity = capacity;
        this.units = units;
        this.name = "Nissan Micra";
        this.mpg = 30;

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

    public String getFuelTankCapacity() {
        return capacity + " " + units;
    }
}
