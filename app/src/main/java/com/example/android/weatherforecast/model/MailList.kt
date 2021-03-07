package com.example.android.weatherforecast.model

import com.google.gson.annotations.SerializedName

class MailList(
    @SerializedName("list")
    val mainList: List<MainObject>
) {
    fun get() = mainList
}

