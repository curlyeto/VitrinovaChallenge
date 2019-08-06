package com.example.chanllegevitrinova.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chanllegevitrinova.Model.AllVitrin

class VitrinViewModel :ViewModel(){
    private val services=RetrofitService()
    private var dataList: MutableLiveData<List<AllVitrin>>? = null
    fun refreshData():MutableLiveData<List<AllVitrin>> ?{
        dataList= MutableLiveData()
        getVitrin()
        return dataList
    }

    fun getVitrin():MutableLiveData<List<AllVitrin>> ?{
        return services.loadAlldata()
    }

}