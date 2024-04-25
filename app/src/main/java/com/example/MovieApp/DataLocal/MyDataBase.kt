package com.example.MovieApp.DataLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.MovieApp.DataLocal.Converters.*
import com.example.MovieApp.Model.DetialsMovieModel
import com.example.MovieApp.Model.Result

@Database(entities = [Result::class, DetialsMovieModel::class], version = 1)
@TypeConverters(GenreIdsConverter::class,CompanyConverter::class,CountryConverter::class,GenresConverter::class,SpokenLangConverter::class,BelongsToCollectionConverter::class)
abstract class MyDataBase :RoomDatabase() {

    abstract fun getDaoMovie(): MyDaoMovie
    abstract fun getDaoDetials(): MyDaoDetialsMovie
    companion object{
      private  var myDatabase: MyDataBase?=null
        fun initDatabase(context:Context){
           myDatabase = Room.databaseBuilder(context, MyDataBase::class.java,"movie")
               .allowMainThreadQueries()
               .fallbackToDestructiveMigration()
               .build()


        }
        fun getDataBase()= myDatabase
    }

}