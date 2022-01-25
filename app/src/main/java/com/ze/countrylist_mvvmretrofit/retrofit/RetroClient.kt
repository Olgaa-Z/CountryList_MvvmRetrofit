package com.ze.countrylist_mvvmretrofit.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroClient {

    companion object {
        //        val BASE_URL =https://restcountries.eu/rest/ "https://restcountries.eu/rest/"//v2/
        val BASE_URL = "https://restcountries.com/v2/"//all

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}