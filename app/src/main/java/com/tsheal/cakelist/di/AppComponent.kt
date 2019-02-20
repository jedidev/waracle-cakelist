package com.tsheal.cakelist.di

import com.tsheal.cakelist.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [AndroidInjectionModule::class, InjectorsModule::class, AppModule::class, MainModule::class])
@AppScope
interface AppComponent: AndroidInjector<MyApplication>