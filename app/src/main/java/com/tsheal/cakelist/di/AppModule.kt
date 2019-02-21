package com.tsheal.cakelist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tsheal.cakelist.interfaces.ICakeService
import com.tsheal.cakelist.api.CakeApi
import com.tsheal.cakelist.interfaces.ICakeItemListener
import com.tsheal.cakelist.interfaces.IDialogService
import com.tsheal.cakelist.service.CakeService
import com.tsheal.cakelist.service.DialogService
import com.tsheal.cakelist.ui.CakeItemListener
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@Module
internal class AppModule {

    companion object {
        private const val BASE_URL = "https://gist.githubusercontent.com/t-reed/739df99e9d96700f17604a3971e701fa/raw/1d4dd9c5a0ec758ff5ae92b7b13fe4d57d34e1dc/"
    }

    @Provides
    @AppScope
    fun provideViewModelFactory(providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return requireNotNull(providers[modelClass as Class<out ViewModel>]).get() as T
        }
    }

    @Provides
    @AppScope
    fun provideCakeApi(): CakeApi {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppModule.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        val cakeApi = retrofit.create(CakeApi::class.java)
        return cakeApi
    }

    @Provides
    @AppScope
    fun provideCakeService(cakeService: CakeService): ICakeService = cakeService

    @Provides
    @AppScope
    fun provideDialogService(dialogService: DialogService): IDialogService = dialogService

    @Provides
    @AppScope
    fun provideCakeItemListener(cakeItemListener: CakeItemListener): ICakeItemListener = cakeItemListener
}