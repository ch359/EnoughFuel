package com.example.android.enoughfuel;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * Created by ragnar on 09/11/2018.
 */
public class Calculator {

    private Car car;
    private Map<String, Double> distanceAllUnits;


    public Calculator(double distance, String distanceUnit, Car car) {
        distanceAllUnits = Conversions.storeDistances(distance, distanceUnit);
        this.car = car;
    }

    public Double fuelUse() {
        double fuelNeeded = distanceAllUnits.get("miles") / car.getMpg();
        return ((fuelNeeded / car.getFuelTankInGallons()) * 100);

    }









}
