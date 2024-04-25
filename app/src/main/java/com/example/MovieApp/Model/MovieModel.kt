package com.example.MovieApp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.MovieApp.DataLocal.Converters.GenreIdsConverter

data class MovieModel(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
@Entity(tableName ="Result")
data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    @TypeConverters(GenreIdsConverter::class)
    val genre_ids: List<Int>,
    @PrimaryKey
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)