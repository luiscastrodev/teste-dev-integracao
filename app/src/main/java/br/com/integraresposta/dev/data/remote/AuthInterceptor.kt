package br.com.integraresposta.dev.data.remote

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPreferences: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPreferences.getString("token", null)

        val newRequest = chain.request().newBuilder().apply {
            token?.let {
                currentToken->
                addHeader("Token", currentToken)
            }
        }.build()

        return chain.proceed(newRequest)
    }
}
