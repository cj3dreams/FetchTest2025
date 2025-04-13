package com.fetchtest.fetch.app.di

import com.fetchtest.fetch.data.repository.DataRepository
import com.fetchtest.fetch.data.repository.DataRepositoryImpl
import com.fetchtest.fetch.data.source.remote.GetFetchListApi
import com.fetchtest.fetch.data.source.remote.RemoteSourceImpl
import com.fetchtest.fetch.ui.vm.MainViewModel
import com.fetchtest.fetch.util.utils.AppConstants.BASE_URL
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    fun <Api> provideRetrofit(api: Class<Api>) =
        Retrofit.Builder().baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)

    factory { provideRetrofit(GetFetchListApi::class.java) }

}
val dataSourceModule = module {
    fun provideDataRepository(api: GetFetchListApi) = DataRepositoryImpl(RemoteSourceImpl(api))

    single { provideDataRepository(get()) }
}
val viewModel = module {
    viewModel{
        MainViewModel(get())
    }
}