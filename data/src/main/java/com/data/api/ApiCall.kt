package com.data.api

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <T, R> ApiCall(
    apiCall : suspend () -> T,
    mapper : (T) -> R,
    dispatcher : CoroutineDispatcher
) : Result<R>{

    return withContext(dispatcher){
        try {
            val response = apiCall()
            val mappedData = mapper(response)
            Result.success(mappedData)
        }catch (throwable : Throwable){
           Result.failure(throwable)
        }
    }
}