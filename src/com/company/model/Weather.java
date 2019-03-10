package com.company.model;


public class Weather {
    private String direction;
    private String date;
    private double temp;
    private long humidity;
    public String name;
    double degree;
    String sighn;


    public Weather(double temp, String name, String direction, String date, long humidity,double degree) {
        this.temp = temp;
        this.name = name;
        this.direction = direction;
        this.date = date;
        this.humidity = humidity;
        this.degree=degree;


    }

    public String getSighn() {
        return sighn;
    }

    public void setSighn(String sighn) {
        this.sighn = sighn;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "direction='" + direction + '\'' +
                ", date='" + date + '\'' +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                ", sighn='" + sighn + '\'' +
                '}';
    }
}