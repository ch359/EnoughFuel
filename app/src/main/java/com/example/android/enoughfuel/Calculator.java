package com.example.android.enoughfuel;

/**
 * Created by ragnar on 09/11/2018.
 */
public class Calculator {



    private double distance;
    private Car car;

    public Calculator(double distance, Car car) {
        this.distance = distance;
        this.car = car;
    }

    public double fuelUse() {
        double fuelNeeded = distance / car.getMpg();
        return (fuelNeeded / car.getFuelTankInGallons()) * 100;
    }









}
