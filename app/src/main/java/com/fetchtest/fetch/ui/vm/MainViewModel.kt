package com.fetchtest.fetch.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetchtest.fetch.data.model.MainModel
import com.fetchtest.fetch.data.repository.DataRepositoryImpl
import com.fetchtest.fetch.data.source.remote.RemoteResult
import com.fetchtest.fetch.domain.usecase.GetFetchListFromRemoteUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepositoryImpl): ViewModel() {

    private val getFetchListFromRemoteUseCase get() = GetFetchListFromRemoteUsecase(dataRepository)
    private val _fetchListLiveData: MutableLiveData<List<MainModel>?> = MutableLiveData()
    val fetchListLiveData: LiveData<List<MainModel>?> = _fetchListLiveData

    fun getFetchListFromRemoteAndSort() = viewModelScope.launch(Dispatchers.IO) {
        when(val remoteResult = getFetchListFromRemoteUseCase.invoke()) {
            is RemoteResult.Success -> {
                val response = remoteResult.data
                _fetchListLiveData.postValue(response)/// sort here
            }
            is RemoteResult.Error ->_fetchListLiveData.postValue(null)
    }
    }
}