package com.company.api;

import com.company.entites.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMap {
    @GET("weather")
    Call<WeatherResponse> getWeatherization(@Query("id") String id,
                                            @Query("appid") String appid,
                                            @Query("units") String units);

}