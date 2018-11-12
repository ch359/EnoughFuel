package com.example.android.enoughfuel;

/**
 * Created by ragnar on 09/11/2018.
 */
public class Calculator {



    private int distance;
    private Car car;

    public Calculator(int distance, Car car) {
        this.distance = distance;
        this.car = car;
    }

    public double fuelUse() {
        double fuelNeeded = distance / car.getMpg();
        return (fuelNeeded / car.getFuelTankCapacityInGallons()) * 100;
    }









}
