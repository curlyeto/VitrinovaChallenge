package com.example.chanllegevitrinova.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.chanllegevitrinova.Model.AllVitrin
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {
    val liveVitrinResponse:MutableLiveData<List<AllVitrin>> = MutableLiveData()

    companion object Factory{
        var gson=GsonBuilder().setLenient().create()

        fun create(): VitrinInterface {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level=HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build()


            val retrofit=Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://www.vitrinova.com/")
                .client(client)
                .build()

            return retrofit.create(VitrinInterface::class.java)
        }


    }

    fun loadAlldata() :MutableLiveData<List<AllVitrin>> ?{

        val callretrofit= create().getAllVitrin()

        callretrofit.enqueue(object : Callback<List<AllVitrin>> {
            override fun onResponse(call: Call<List<AllVitrin>>, response: retrofit2.Response<List<AllVitrin>>) {
                liveVitrinResponse.value =response.body()
            }

            override fun onFailure(call: Call<List<AllVitrin>>, t: Throwable?) {
                if (t != null) {
                    Log.e("onFailure :", t.message)
                }
            }
        })

        return liveVitrinResponse
    }
}
