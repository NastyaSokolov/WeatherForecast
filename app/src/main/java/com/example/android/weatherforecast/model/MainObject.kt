package com.example.android.weatherforecast.model

import com.google.gson.annotations.SerializedName

class MainObject(
    @SerializedName("main")
    val main: DayTemp,
    @SerializedName("dt_txt")
    val data: String
)
