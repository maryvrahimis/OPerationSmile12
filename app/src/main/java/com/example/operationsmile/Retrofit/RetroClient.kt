package com.example.operationsmile.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetroClient {
    private var instance:Retrofit?=null

    fun getInstance(): Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        }
        return instance!!
    }
}