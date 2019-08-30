package com.schetckina.dogbreedapp.api.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.schetckina.dogbreedapp.api.response.AllBreedResponse
import com.schetckina.dogbreedapp.model.enteties.Breed
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.logging.Level

private const val BASE_URL = "https://dog.ceo/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val loggingInterceptor = HttpLoggingInterceptor()


val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)).build()

val retrofit: Retrofit = Retrofit.Builder()
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()


interface BreedService {


    @GET("api/breeds/list/all")
    fun getAllBreadsAsync(): Deferred<AllBreedResponse>




}

object BreedApi {
    val retrofitService : BreedService by lazy {
        retrofit.create(BreedService::class.java) }
}