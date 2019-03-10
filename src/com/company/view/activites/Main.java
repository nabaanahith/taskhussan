package com.company.view.activites;

import com.company.model.Weather;
import com.company.model.entity.WeatherResponse;
import com.company.presenter.MainPresenter;
import com.company.view.ViewInterface;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.security.KeyStore;
import java.util.*;

public class  Main  {

    public static void main(String[] args)  {
        MainPresenter mainPresenter;

        Scanner scan= new Scanner(System.in);

        System.out.println("Do u want to Display as sorting ? Y/N");

        String sortingOption=scan.nextLine();


       mainPresenter = new MainPresenter();
        mainPresenter.getWeatherInformation(sortingOption);




    }

    public static void onSortedDataReceive(List<Map.Entry<String, List<Weather>>> weathermodel) {

for(Map.Entry<String, List<Weather>> cityweather:weathermodel){
    System.out.println(cityweather.getValue());
}

System.out.println("======================================================================================");

    }


    public static void onDataReceive(HashMap<String, List<Weather>> weathermodel) {

     for (List<Weather> s:weathermodel.values() ){

         System.out.println(s);
     }
        System.out.println("======================================================================================"+"\n");

    }


}
