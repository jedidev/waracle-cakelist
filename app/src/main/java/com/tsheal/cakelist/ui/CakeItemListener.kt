package com.tsheal.cakelist.ui

import com.tsheal.cakelist.model.Cake
import com.tsheal.cakelist.service.DialogService
import javax.inject.Inject

class CakeItemListener @Inject constructor(
    private val dialogService: DialogService
) {
    fun onItemClick(cake: Cake) {
        dialogService.displayAlert("Description", cake.desc)
    }
}