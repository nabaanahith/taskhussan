package com.company.view;

import com.company.model.Weather;
import com.company.model.entity.WeatherResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ViewInterface {
   void  onDataOnlineReceive(HashMap<String, List<Weather>> weathermodel);
    void onDataOnlinesortedReceive(List<Map.Entry<String, List<Weather>>> weathermodel);
}
