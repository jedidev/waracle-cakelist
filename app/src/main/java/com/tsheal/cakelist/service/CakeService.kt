package com.tsheal.cakelist.service

import android.util.Log
import com.tsheal.cakelist.api.CakeApi
import com.tsheal.cakelist.model.Cake
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class CakeService @Inject constructor(
    private val cakeApi: CakeApi
) {

    fun getCakesAsync(): Deferred<List<Cake>> {
        return GlobalScope.async {
            val cakes = cakeApi.getCakesAsync().await()
            Log.d("", "${cakes.count()}")
            cakes
        }
    }
}