package com.example.taweesoft.maptest2;

/**
 * Created by TAWEESOFT on 2/23/16 AD.
 */
public class MyPlace {
    private double latitude , longitude;
    private String name;

    public MyPlace(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
