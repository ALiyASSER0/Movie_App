package com.example.MovieApp.DataLocal

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.MovieApp.Model.Result

@androidx.room.Dao
interface MyDaoMovie {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertMovies(list: List<Result>)

@Query("select * from Result")
suspend fun getAllMovies():List<Result>

}