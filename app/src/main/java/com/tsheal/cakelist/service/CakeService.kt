package com.tsheal.cakelist.service

import android.util.Log
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tsheal.cakelist.api.CakeApi
import com.tsheal.cakelist.model.Cake
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CakeService {

    companion object {
        private const val BASE_URL = "https://gist.githubusercontent.com/t-reed/739df99e9d96700f17604a3971e701fa/raw/1d4dd9c5a0ec758ff5ae92b7b13fe4d57d34e1dc/"
    }

    private val cakeApi: CakeApi

    init {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(CakeService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        cakeApi = retrofit.create(CakeApi::class.java)
    }

    fun getCakesAsync(): Deferred<List<Cake>> {
        return GlobalScope.async {
            val cakes = cakeApi.getCakesAsync().await()
            Log.d("", "${cakes.count()}")
            cakes
        }
    }
}