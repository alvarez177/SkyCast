package com.bold.data.network

import com.bold.data.model.ForecastResponseApi
import com.bold.data.model.LocationApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("search.json")
    suspend fun fetchLocations(@Query("q") location: String): Response<List<LocationApi>>

    @GET("forecast.json")
    suspend fun fetchForecast(
        @Query("q") location: String,
        @Query("days") forecastDays: Int = 3
    ): Response<ForecastResponseApi>
}