package com.example.android.weatherforecast

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.weatherforecast.databinding.ActivityMainBinding
import com.example.android.weatherforecast.model.MailList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.openweathermap.org/")
            .build()
        retrofit.create(jsonApi::class.java)
            .getInfo()
            .enqueue(object : Callback<MailList> {
                override fun onFailure(call: Call<MailList>, t: Throwable) {
                    Log.e("MyError", t.message.toString())
                }

                override fun onResponse(call: Call<MailList>, response: Response<MailList>) {
                    var averTemp = 0.0
                    var maxTemp: String
                    var temp = ""
                    val mainList = response.body()?.get()
                    if (mainList != null) {
                        maxTemp = mainList[0].main.max
                        for (i in mainList.indices) {
                            if (mainList[i].data.contains("06:00")) {
                                averTemp += mainList[i].main.max.toDouble()
                                temp =
                                    temp + mainList[i].data + "     " + mainList[i].main.temp + "\n"
                                if (mainList[i].main.max > maxTemp) {
                                    maxTemp = mainList[i].main.max
                                }
                            }
                        }
                        val df = DecimalFormat("#.##")
                        binding.averageTemp.text = (df.format(averTemp / 5)).toString()
                        binding.maxTemp.text = maxTemp
                        binding.forecast.text = temp
                    }
                }
            })
    }
}



