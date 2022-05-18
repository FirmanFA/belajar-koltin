package com.example.myapplication.data

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }


    fun getInstance(context: Context): ApiService {

        val instance: ApiService by lazy {

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor {
                    val request = it.request()
                    val queryBuild =  request.url
                        .newBuilder()
                        .addQueryParameter("api_key","5374e8eba1107b24236cc30d17d5aa11").build()
                    return@addInterceptor it.proceed(request.newBuilder().url(queryBuild).build())
                }
//                .addInterceptor(
//                    ChuckerInterceptor.Builder(context.applicationContext)
//                        .collector(ChuckerCollector(context.applicationContext))
//                        .maxContentLength(250000L)
//                        .redactHeaders(emptySet())
//                        .alwaysReadResponseBody(false)
//                        .build()
//                )
                .build()


            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            retrofit.create(ApiService::class.java)
        }

        return instance
    }


}
