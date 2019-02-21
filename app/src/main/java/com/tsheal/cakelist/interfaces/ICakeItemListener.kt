package com.tsheal.cakelist.interfaces

import com.tsheal.cakelist.model.Cake

interface ICakeItemListener {
    fun onItemClick(cake: Cake)
}