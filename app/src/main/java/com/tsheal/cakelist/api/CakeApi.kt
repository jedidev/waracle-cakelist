package com.tsheal.cakelist.api

import com.tsheal.cakelist.model.Cake
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CakeApi {

    @GET("waracle_cake-android-client")
    fun getCakesAsync(): Deferred<List<Cake>>
}