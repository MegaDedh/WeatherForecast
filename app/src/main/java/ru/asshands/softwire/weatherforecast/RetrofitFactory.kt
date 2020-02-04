package ru.asshands.softwire.weatherforecast

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import ru.asshands.softwire.weatherforecast.data.WeatherData
import java.util.*

class RetrofitFactory {

    companion object {
        const val baseUrl = "http://api.openweathermap.org/"

    }


    private fun getRetrofit(): Retrofit {

        val okHttpClientBuilder = OkHttpClient.Builder()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
    }

    fun getApi() = getRetrofit().create(Api::class.java)!!

}