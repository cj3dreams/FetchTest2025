package com.fetchtest.fetch.data.repository

import com.fetchtest.fetch.data.model.MainModel
import com.fetchtest.fetch.data.source.remote.RemoteResult

interface DataRepository {
    suspend fun getFetchListFromRemote(): RemoteResult<List<MainModel>>
}