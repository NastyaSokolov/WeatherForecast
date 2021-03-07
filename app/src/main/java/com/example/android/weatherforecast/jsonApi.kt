package com.example.android.weatherforecast

import com.example.android.weatherforecast.model.MailList
import retrofit2.Call
import retrofit2.http.GET

interface jsonApi {
    @GET("data/2.5/forecast?q=Nagold&units=metric&appid=3553f24866a4d90033e0715c4cd5b147")
    fun getInfo(
    ): Call<MailList>
}