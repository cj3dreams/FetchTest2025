package com.fetchtest.fetch.data.source.remote

import com.fetchtest.fetch.data.model.MainModel
import retrofit2.Response
import retrofit2.http.GET

interface GetFetchListApi {

    @GET("hiring.json")
    suspend fun getFetchListApi(): Response<List<MainModel>>
}