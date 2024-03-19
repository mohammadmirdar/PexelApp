package ir.mirdar.pexelmovieapp.data.remote

import ir.mirdar.pexelmovieapp.presentation.common.Utils.API_KEY
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject


class RequestInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest : Request
        try {
             newRequest = request.newBuilder()
                .addHeader("Authorization", API_KEY)
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
            return chain.proceed(request)
        }

        return chain.proceed(newRequest)
    }
}