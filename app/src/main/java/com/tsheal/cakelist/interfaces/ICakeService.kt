package com.tsheal.cakelist.interfaces

import com.tsheal.cakelist.model.Cake
import kotlinx.coroutines.Deferred

interface ICakeService {
    fun getCakesAsync(): Deferred<List<Cake>>
}