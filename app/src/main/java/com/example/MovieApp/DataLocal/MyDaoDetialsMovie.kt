package com.example.MovieApp.DataLocal

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.MovieApp.Model.DetialsMovieModel

@androidx.room.Dao
interface MyDaoDetialsMovie {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertDetialsMovies(list: DetialsMovieModel)

@Query("select * from DetialsMovieModel")
suspend fun getAllDetialsMovies():DetialsMovieModel

}