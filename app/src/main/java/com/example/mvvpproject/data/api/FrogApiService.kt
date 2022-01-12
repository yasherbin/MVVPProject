package com.example.mvvpproject.data.api

import com.example.mvvpproject.data.model.Frog
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL="https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FrogApiService {
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getFrogs(): List<Frog>
}


object MarsApi {
    val retrofitService: FrogApiService by lazy { retrofit.create(FrogApiService::class.java) }
}