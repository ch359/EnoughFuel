package com.example.android.enoughfuel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ragnar on 10/11/2018.
 */
public final class Conversions {

    private static final double MILES_KM_RATIO = 1.609344;
    private static final double LITRE_GALLON_IMP_RATIO = 0.2199692;

    public static double milesToKm(double miles) {
        return miles * MILES_KM_RATIO;
    }

    public static double kmToMiles(double km) {
        return km / MILES_KM_RATIO;
    }

    public static double litresToGallons(double litres) {
        return litres * LITRE_GALLON_IMP_RATIO;
    }

    public static double gallonsToLitres(double gallons) {
        return gallons / LITRE_GALLON_IMP_RATIO;
    }

    public static Map<String, Double> storeFuelTankCapacity(double capacity, String units) {
        Map<String, Double> fuelTank = new HashMap<>();
        if (units.toLowerCase().equals("gallons")) {
            fuelTank.put(units.toLowerCase(), capacity);
            fuelTank.put("litres", gallonsToLitres(capacity));
        }
        else if (units.toLowerCase().equals("litres")) {
            fuelTank.put(units.toLowerCase(), capacity);
            fuelTank.put("gallons", litresToGallons(capacity));
        }
        return fuelTank;
    }

}
