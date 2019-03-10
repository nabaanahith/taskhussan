package com.company.model.entity;

import java.util.Date;

public class Wind {
    private String sighn="+";
    private double speed;
    private Double deg;
private  String  directio;
private String date;

    public String getSigh() {
        return sighn;
    }

    public void setSigh(String sigh) {
        this.sighn = sigh;

    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDirectio() {
        return directio;
    }

    public void setDirectio(String directio) {
        this.directio = directio;
    }

    public double getSpeed() { return speed; }

    public void setSpeed(double value) { this.speed = value; }

    public Double getDeg() { return deg; }
    public void setDeg(Double value) { this.deg = value; }}