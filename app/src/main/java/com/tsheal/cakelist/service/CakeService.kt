package com.tsheal.cakelist.service

import com.tsheal.cakelist.interfaces.ICakeService
import com.tsheal.cakelist.api.CakeApi
import com.tsheal.cakelist.model.Cake
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

open class CakeService @Inject constructor(
    private val cakeApi: CakeApi
): ICakeService {

    override fun getCakesAsync(): Deferred<List<Cake>> {
        return GlobalScope.async {
            val cakes = cakeApi.getCakesAsync().await()
            val distinctCakes = cakes.distinctBy { it.title }
            val sortedCakes = distinctCakes.sortedBy { it.title }
            sortedCakes
        }
    }
}