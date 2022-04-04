package com.example.operationsmile.Retrofit


import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableAll
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

interface IMyService {
    @POST("register")
    @FormUrlEncoded
    fun registeredUser(@Field("email") email:String,@Field("name") name:String,@Field("password")):Observable<String>

    @POST("login")
    @FormUrlEncoded
    fun loginUser(@Field("email") email:String,@Field("password") password:String):Observable<String>

}