package com.fetchtest.fetch.data.source.remote

import com.fetchtest.fetch.data.model.MainModel

interface RemoteSource {
    suspend fun getFetchListFromRemote(): RemoteResult<List<MainModel>>
}