package com.tsheal.cakelist

import android.app.Activity
import android.app.Application
import com.tsheal.cakelist.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().build().inject(this)
    }
    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}