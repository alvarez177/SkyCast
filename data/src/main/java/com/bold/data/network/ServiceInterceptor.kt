package com.bold.data.network

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {

    companion object {
        private const val API_KEY = "2539a13f9e48441cb1a225016242504"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = API_KEY
        var original = chain.request()
        val url = original.url.newBuilder().addQueryParameter("key", apiKey).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}