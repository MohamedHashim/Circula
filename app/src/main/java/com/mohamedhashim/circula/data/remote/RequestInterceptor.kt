package com.mohamedhashim.circula.data.remote

import com.mohamedhashim.circula.contentType
import com.mohamedhashim.circula.contentTypeValue
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val request = originalRequest.newBuilder()
            .header(contentType, contentTypeValue)
            .method(originalRequest.method, originalRequest.body)
            .build()

        return chain.proceed(request)
    }
}