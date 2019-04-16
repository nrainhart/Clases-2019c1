package ar.edu.utn.frba.mobile.a2019c1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TwitterApi {
    @GET("list")
    fun listRepos(): Call<TweetsTO>
}

data class TweetsTO(val tweets: List<Tweet>)

val twitterApi = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create()) // Para parsear automágicamente el json
    .baseUrl("https://demo0682762.mockable.io/")
    .build()
    .create(TwitterApi::class.java) // la interfaz que diseñaron antes