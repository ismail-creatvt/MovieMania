package com.ismail.creatvt.moviemania

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitFactory {

    private var instance:Retrofit?= null

    fun getInstance():Retrofit{
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }
}