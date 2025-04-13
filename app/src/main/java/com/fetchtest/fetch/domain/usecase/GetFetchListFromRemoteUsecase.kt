package com.fetchtest.fetch.domain.usecase

import com.fetchtest.fetch.data.model.MainModel
import com.fetchtest.fetch.data.repository.DataRepository
import com.fetchtest.fetch.data.source.remote.RemoteResult

class GetFetchListFromRemoteUsecase(private val dataRepository: DataRepository) {
    suspend operator fun invoke() = when (val data = dataRepository.getFetchListFromRemote()){
        is RemoteResult.Success -> {
            val filteredData = data.data.filter { !it.name.isNullOrBlank() }

            val sortedData = filteredData.sortedWith(
                compareBy<MainModel> { it.listId }
                    .thenBy { extractIntFromName(it.name!!) }
            )

            RemoteResult.Success(sortedData)
            }
        is RemoteResult.Error -> data
        }
    private fun extractIntFromName(name: String): Int {
        val digits = name.replace(Regex("\\D"), "")
        return digits.toIntOrNull() ?: Int.MAX_VALUE
    }
    }