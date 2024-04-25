package com.example.MovieApp.DataLocal.Converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class GenreIdsConverter {

    @TypeConverter
    fun fromString(value:String):List<Int>{
      val listType: Type =object :TypeToken<List<Int>>(){}.type

        return Gson().fromJson(value,listType)

    }
    @TypeConverter
   fun fromArrayToGson(list: List<Int>):String{
       return Gson().toJson(list)
   }

}