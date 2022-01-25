package com.ze.countrylist_mvvmretrofit.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ze.countrylist_mvvmretrofit.data.CountryModel
import com.ze.countrylist_mvvmretrofit.retrofit.RetroClient
import com.ze.countrylist_mvvmretrofit.retrofit.RetrofitServiceInterface
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel : ViewModel() {


    lateinit var liveDataList : MutableLiveData<List<CountryModel>>

    init{
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<CountryModel>>{
        return liveDataList
    }

    fun makeApiCall(){
        val retrofitInstance = RetroClient.getRetroInstance()
        val retrofitService = retrofitInstance.create(RetrofitServiceInterface::class.java)
        val call = retrofitService.getCountryList()
        call.enqueue(object : retrofit2.Callback<List<CountryModel>>{
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}