package com.example.chanllegevitrinova.viewmodel

import com.example.chanllegevitrinova.Model.AllVitrin
import retrofit2.Call
import retrofit2.http.GET

interface VitrinInterface {
    @GET("api/v2/discover")
    fun getAllVitrin(): Call<List<AllVitrin>>
}