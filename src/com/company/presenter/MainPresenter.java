package com.company.presenter;



import com.company.helpers.WeatherResponseInterface;
import com.company.model.MainModel;
import com.company.model.ModelInterface;
import com.company.model.Weather;
import com.company.view.activites.Main;

import java.util.*;

public class MainPresenter implements InterfacePresenter {
    private ModelInterface model;

    public MainPresenter() {
        model = new MainModel();
    }


    public void getWeatherInformation(String  flag) {

        model.doGetWeatherInformation(flag,new WeatherResponseInterface() {

            @Override
            public void onDataSetSuccessfully(HashMap<String, List<Weather>> value) {
                if(flag.equals("y")) {
                    List<Map.Entry<String, List<Weather>>> b = new LinkedList<Map.Entry<String, List<Weather>>>(value.entrySet());
                    Collections.sort(b, (o1, o2) -> (int) ((o1.getValue().get(0).getTemp()) - (o2.getValue().get(0).getTemp())));

                    Main.onSortedDataReceive(b);

                }

else {
                    Main.onDataReceive(value);
                }

            }

            @Override
            public void onInternetNotConnected(HashMap<String, List<Weather>> message) {
              System.out.println(message);

            }

        });

    }
}

