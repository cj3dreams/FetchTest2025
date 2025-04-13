package com.fetchtest.fetch.data.source.remote

import com.fetchtest.fetch.data.model.MainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteSourceImpl(private val api: GetFetchListApi): RemoteSource {
    override suspend fun getFetchListFromRemote(): RemoteResult<List<MainModel>> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.getFetchListApi()
                 if (response.isSuccessful) return@withContext RemoteResult.Success(response.body()!!)
                else return@withContext RemoteResult.Error(Exception(response.message()))
            }
            catch (e: Exception){
                return@withContext RemoteResult.Error(e)
            }
        }
}