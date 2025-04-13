package com.fetchtest.fetch.data.repository

import com.fetchtest.fetch.data.source.remote.RemoteSource

class DataRepositoryImpl(private val remoteSource: RemoteSource): DataRepository {
    override suspend fun getFetchListFromRemote() = remoteSource.getFetchListFromRemote()

}