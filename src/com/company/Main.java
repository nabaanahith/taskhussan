package com.company;

import com.company.entites.Weather;
import com.company.models.CallingMethods;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CallingMethods callingMethods;
        callingMethods = new CallingMethods();
        Scanner scan = new Scanner(System.in);
        System.out.println("hi m.r/m.s :) .. Do u want to Display Weather State In  a sorting Order ? Y/N");
        String sortingOption = scan.nextLine();
        callingMethods.getWeatherInformation(sortingOption);

    }

    public static void onSortedDataReceive(List<Map.Entry<String, List<Weather>>> weathermodel) {

        for (Map.Entry<String, List<Weather>> cityweather : weathermodel) {
            System.out.println(cityweather.getValue());
        }

        System.out.println("======================================================================================");

    }


    public static void onDataReceive(HashMap<String, List<Weather>> weathermodel) {

        for (List<Weather> s : weathermodel.values()) {

            System.out.println(s);
        }
        System.out.println("======================================================================================" + "\n");

    }


}

