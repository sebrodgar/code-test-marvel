package com.srg.pruebamarvel.common.di.modules

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.srg.pruebamarvel.BuildConfig
import com.srg.pruebamarvel.common.extensions.toMD5
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by sebrodgar on 26/02/2021.
 */
@Module
object RemoteModule {

    private const val READ_TIMEOUT_SECONDS = 40L
    private const val WRITE_TIMEOUT_SECONDS = 40L

    @Provides
    fun provideRetrofitService(context: Context): Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443/v1/public/")
        .client(provideOkHttpClient(context))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClient(context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .collector(ChuckerCollector(context))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url
                val timeStamp = System.currentTimeMillis().toString()
                val urlBuilder = originalHttpUrl.newBuilder()
                    .addQueryParameter("ts", timeStamp)
                    .addQueryParameter("apikey", BuildConfig.API_PUBLIC_KEY)
                    .addQueryParameter("hash", calculateHash(timeStamp))
                    .build()

                val requestBuilder = original.newBuilder().url(urlBuilder)

                val request = requestBuilder.build()
                chain.proceed(request)
            })
            .build()


    private fun calculateHash(timeStamp: String) =
        "$timeStamp${BuildConfig.API_PRIVATE_KEY}${BuildConfig.API_PUBLIC_KEY}".toMD5()
}