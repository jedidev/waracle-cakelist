package com.tsheal.cakelist.di

import com.tsheal.cakelist.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InjectorsModule {

    @ContributesAndroidInjector(modules = [MainModule.InjectMainViewModel::class])
    abstract fun provideMainActivity(): MainActivity
}