package com.tsheal.cakelist.ui

import androidx.databinding.Bindable
import com.tsheal.cakelist.BR
import com.tsheal.cakelist.mvvm.BaseViewModel
import com.tsheal.cakelist.service.CakeService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val cakeService: CakeService
): BaseViewModel() {

    init {
        GlobalScope.launch {
            val cakes = cakeService.getCakesAsync().await()
        }
    }

    @Bindable
    var inProgress: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.inProgress)
        }

    fun refresh() {

    }

    @Bindable
    var atLeastOneCake: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.atLeastOneCake)
        }
}