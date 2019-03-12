package com.company.helpers;


import com.company.entites.Weather;

import java.util.HashMap;
import java.util.List;

public interface WeatherResponseInterface {
  void onDataSetSuccessfully(HashMap<String, List<Weather>> erroeMesg);

}