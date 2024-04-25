package com.example.MovieApp.Network

import com.example.MovieApp.Const
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetroConnect {

     private val retrofit:Retrofit by lazy {
        Retrofit.Builder().baseUrl(Const.BASE_UIL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

        val apiService: ApiCall by lazy {
            retrofit.create(ApiCall::class.java)
        }



}

