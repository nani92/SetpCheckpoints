package com.nataliajastrzebska.besetupcheckpoints;

import android.util.Log;

/**
 * Created by nataliajastrzebska on 18/11/15.
 */
public class BeaconLocation {
    private float x, y;
    private String id;
    private int rssi;
    private boolean isChecked = false;
    private float radius;

    public BeaconLocation(String id, float x, float y){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void setRadius(float radius){
        Log.d("natalia", "set radius " + radius);
        this.radius = radius;
    }

    public float getRadius(){
        return radius;
    }



    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getId() {
        return id;
    }

    public boolean getIsChecked(){
        return isChecked;
    }

    public void checkNFC(){
        isChecked = true;
    }
}
