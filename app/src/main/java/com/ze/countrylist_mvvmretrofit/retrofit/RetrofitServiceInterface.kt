package com.ze.countrylist_mvvmretrofit.retrofit


import com.ze.countrylist_mvvmretrofit.data.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInterface {

    @GET("all")
    fun getCountryList(): Call<List<CountryModel>>

}