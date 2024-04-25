package com.example.MovieApp.DataLocal.Converters

import androidx.room.TypeConverter
import com.example.MovieApp.Model.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class GenresConverter {


    @TypeConverter
    fun fromString(value:String):List<Genre>{
        val listType: Type =object :TypeToken<List<Genre>>(){}.type

        return Gson().fromJson(value,listType)

    }
    @TypeConverter
    fun fromArrayToGson(list: List<Genre>):String{
        return Gson().toJson(list)
    }

}