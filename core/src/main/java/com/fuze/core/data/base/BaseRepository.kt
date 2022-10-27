package com.fuze.core.data.base

import com.fuze.core.data.exceptions.*
import com.fuze.core.data.response.HttpExceptionErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException

open class BaseRepository {
    private val _tag = this@BaseRepository::class.simpleName

    @Throws(
        BadRequestException::class,
        UnauthorizedException::class,
        NotFoundException::class,
        UnknownErrorException::class
    )
    fun parseErrorResponse(throwable: Throwable): Throwable {
        return when (throwable) {
            is HttpException -> {
                when (throwable.code()) {
                    400 -> BadRequestException(
                        getErrorMessageFromErrorBody(
                            errorBody = throwable.response()?.errorBody()
                        )
                    )
                    401 -> UnauthorizedException(
                        getErrorMessageFromErrorBody(
                            errorBody = throwable.response()?.errorBody()
                        )
                    )
                    404 -> NotFoundException()
                    503 -> ServiceUnavailableException()
                    else -> UnknownErrorException()
                }
            }
            is ConnectException, is IOException -> InternetNotAvailableException(throwable.message)
            is EmptyDataException -> EmptyDataException()
            else -> throwable
        }
    }

    private fun getErrorMessageFromErrorBody(errorBody: ResponseBody?): String? {
        errorBody?.string().orEmpty().let {
            return Gson().fromJson(
                it,HttpExceptionErrorResponse::class.java
            ).error
        }
    }
}