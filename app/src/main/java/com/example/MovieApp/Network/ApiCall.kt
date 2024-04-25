package com.example.MovieApp.Network

import com.example.MovieApp.Const
import com.example.MovieApp.Model.DetialsMovieModel
import com.example.MovieApp.Model.MovieModel
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCall {

@GET("discover/movie")
suspend fun getMovie(@Query("api_key") apiKey: String = Const.API_KEY):MovieModel
@GET("movie/{id}")
suspend fun getDetialsMovie(@Path("id") id:Int,@Query("api_key") apiKey: String = Const.API_KEY):DetialsMovieModel



}