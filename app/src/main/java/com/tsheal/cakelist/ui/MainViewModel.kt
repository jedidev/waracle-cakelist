package com.tsheal.cakelist.ui

import androidx.databinding.Bindable
import com.tsheal.cakelist.BR
import com.tsheal.cakelist.mvvm.BaseViewModel

class MainViewModel: BaseViewModel() {

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