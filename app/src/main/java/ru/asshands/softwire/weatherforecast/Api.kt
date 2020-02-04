package ru.asshands.softwire.weatherforecast

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.asshands.softwire.weatherforecast.data.WeatherData


interface Api {

    @GET("data/2.5/weather")

    fun getWeatherDataByCity(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ): Observable<WeatherData>
}