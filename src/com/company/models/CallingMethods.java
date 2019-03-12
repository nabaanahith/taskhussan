package com.company.models;


import com.company.helpers.WeatherResponseInterface;
import com.company.entites.Weather;

import java.util.*;

import static com.company.Main.onDataReceive;
import static com.company.Main.onSortedDataReceive;

public class CallingMethods {
    private GetUpdatedWeatherState mainModel = new GetUpdatedWeatherState();
    private String flag;

    public CallingMethods() {

    }

    WeatherResponseInterface weatherResponseInterface = new WeatherResponseInterface() {
        @Override
        public void onDataSetSuccessfully(HashMap<String, List<Weather>> value) {

            if (flag.equals("y")) {
                onSortedDataReceive(sortingByTemp(value));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                onDataReceive(value);


            }

        }

    };

    private List<Map.Entry<String, List<Weather>>> sortingByTemp(HashMap<String, List<Weather>> value) {
        List<Map.Entry<String, List<Weather>>> sorttedLiist = new LinkedList<Map.Entry<String, List<Weather>>>(value.entrySet());
        Collections.sort(sorttedLiist, (o1, o2) -> (int) ((o1.getValue().get(0).getTemp()) - (o2.getValue().get(0).getTemp())));
        return sorttedLiist;
    }

    public void getWeatherInformation(String flag) {
        if (!flag.equals("y") && !flag.equals("n")) {
            System.out.println("ok sir u enter wrong choose so the default weather order will display...thank you.");
        }
        System.out.printf("\r%s", "city" + " \t\t\t\t\t temp" + " \t\t\t\t\t  humidity" + " \t\t\t\t\t  change" + " \t\t\t\t\t  last update" + "\n");

        this.flag = flag;
        mainModel.GetWeatherInformation(weatherResponseInterface);

    }
}


