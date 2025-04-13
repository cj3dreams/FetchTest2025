package com.fetchtest.fetch.data.source.remote

sealed class RemoteResult<out T> {

    data class Success<out T> (val data: T): RemoteResult<T>()
    data class Error (val e: Exception): RemoteResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Error-> "Error[e= $e]"
        }
    }
}