package com.company.models;

import com.company.api.Clint;
import com.company.api.OpenWeatherMap;
import com.company.entites.Sys;
import com.company.entites.Weather;
import com.company.entites.WeatherResponse;
import com.company.helpers.WeatherResponseInterface;
import com.company.models.DateConverter;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Runnable;

public class Runnablle {
    private OpenWeatherMap apiServices;

    ExecutorService executor = Executors.newFixedThreadPool(5);

    int i = 0;
    HashMap<String, double[]> map2 = new HashMap<>();
    private HashMap<String, List<Weather>> map = new HashMap<>();

    public void getResponse(String cites[],WeatherResponseInterface weatherResponseInterface) {


        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (map.size() < 5) {
                    int finalI = map.size();

                    List<Weather> newResponse = new ArrayList<>();
                    newResponse.addAll(getWeatherStat(cites[finalI]));


                    map.put(cites[finalI], newResponse);


                    try {
                        Thread.sleep((long) map2.get(cites[i])[2]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (map.size() == 5) {
//                        System.out.println(map.toString());
                        weatherResponseInterface.onDataSetSuccessfully(map);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        map.clear();
                    }
                }
            }
        });

    }


    private List<Weather> getWeatherStat(String id) {
        apiServices = Clint.getRetrofit().create(OpenWeatherMap.class);

        List<Weather> weatherStateList = new ArrayList<>();
        Call<WeatherResponse> call = apiServices.getWeatherization(id, DateConverter.API_KEY, "metric");
        Response<WeatherResponse> result = null;
        try {
            result = call.execute();
            if (result.isSuccessful()) {
                DateConverter dateConverter = new DateConverter();
                Weather newValue = new Weather(result.body().getMain().getTemp(), result.body().getName(), result.body().getWind().getDirectio(), dateConverter.getDateNow(), result.body().getMain().getHumidity(), result.body().getWind().getDeg());
                setDirection(newValue);
                weatherStateList.add(newValue);
                if (map2.get(id) != null) {
                    if (camper(map2.get(id)[0] , newValue.getTemp())==1) {
                        map2.get(id)[1]--;
                        weatherStateList.get(0).setSighn(" + ");


                    } else if (camper(map2.get(id)[0] , newValue.getTemp())==2) {
                        map2.get(id)[1]--;
                        weatherStateList.get(0).setSighn(" - ");

                    } else {
                        map2.get(id)[1]++;
                        weatherStateList.get(0).setSighn(" not change ");

                    }
                } else {
                    map2.put(id, new double[]{newValue.getTemp(), 0.0, 2000.0});
                    weatherStateList.get(0).setSighn("........ ");


                }
                if (map2.get(id)[1] == 3) {
                    map2.get(id)[1]--;

                    try {
                        System.out.println(newValue.getName() + "\t" + "Sleep now ...");
                        Thread.sleep((long) map2.get(id)[2]);
                        System.out.println(newValue.getName() + "\t" + "back now :)");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("some hing wrong that may caused by " + e.getMessage());
        }

        return weatherStateList;
    }

    private static void setDirection(Weather weatherResponse) {
        weatherResponse.setDirection(getDirectionInStringFormat(weatherResponse.getDegree()));
    }

    public static String getDirectionInStringFormat(double x) {

        String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"};
        return directions[(int) Math.round((((double) x % 360) / 45))];
    }
    int camper(double oldValueTemperature, double currentValueTemperature) {

        if (oldValueTemperature > currentValueTemperature) {
            return 1;
        } else if (oldValueTemperature < currentValueTemperature) {
            return 2;
        }
        return 0;

    }

}