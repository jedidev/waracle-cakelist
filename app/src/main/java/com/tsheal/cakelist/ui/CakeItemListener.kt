package com.tsheal.cakelist.ui

import com.tsheal.cakelist.interfaces.ICakeItemListener
import com.tsheal.cakelist.interfaces.IDialogService
import com.tsheal.cakelist.model.Cake
import javax.inject.Inject

open class CakeItemListener @Inject constructor(
    private val dialogService: IDialogService
): ICakeItemListener {

    override fun onItemClick(cake: Cake) {
        dialogService.displayAlert("Description", cake.desc)
    }
}