package com.company.helpers;


import com.company.model.Weather;
import com.company.model.entity.WeatherResponse;

import java.util.HashMap;
import java.util.List;

public interface WeatherResponseInterface {
  void onDataSetSuccessfully(HashMap<String, List<Weather>> erroeMesg);
  void onInternetNotConnected(HashMap<String, List<Weather>> erroeMesg);

}