package com.example.android.enoughfuel;

import java.util.Map;

/**
 * Created by ragnar on 09/11/2018.
 */
public class Car {

    private String name;
    Map<String, Double> fuelTank;
    private double mpg;

    public Car(double capacity, String units) {
        fuelTank = Conversions.storeFuelTankCapacity(capacity, units);
        this.name = "Nissan Micra";
        this.mpg = 30;

    }

    public String getName() {
        return name;
    }

    public double getFuelTankInGallons() {
        String units = "gallons";
        return fuelTank.get(units);
    }

    public double getFuelTankInLitres() {
        String units = "litres";
        return fuelTank.get(units);
    }

    public double getMpg() {
        return mpg;
    }

    public String displayFuelTankCapacity(String units) {
        switch (units) {
            case "gallons":
                return getFuelTankInGallons() + " " + units;

            case "litres":
                return getFuelTankInLitres() + " " + units;

        }
        return null;

    }

}
