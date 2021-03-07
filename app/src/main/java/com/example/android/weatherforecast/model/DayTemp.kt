package com.example.android.weatherforecast.model

import com.google.gson.annotations.SerializedName

class DayTemp(
    @SerializedName("temp_max")
    val max: String,
    @SerializedName("temp")
    val temp: String

)