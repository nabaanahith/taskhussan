package com.company.model;

import com.company.helpers.WeatherResponseInterface;

public interface ModelInterface {
    void doGetWeatherInformation(String  flag, WeatherResponseInterface onWeatherResponse);
}
