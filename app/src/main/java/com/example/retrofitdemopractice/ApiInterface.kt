package com.example.retrofitdemopractice

import com.example.retrofitdemopractice.Api.Movie
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("movielist.json")
    fun getMovies(): Call<List<Movie>>

}