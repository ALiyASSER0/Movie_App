package com.example.MovieApp.DataLocal.Converters

import androidx.room.TypeConverter
import com.example.MovieApp.Model.SpokenLanguage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SpokenLangConverter {


    @TypeConverter
    fun fromString(value:String):List<SpokenLanguage>{
        val listType: Type =object :TypeToken<List<SpokenLanguage>>(){}.type

        return Gson().fromJson(value,listType)

    }
    @TypeConverter
    fun fromArrayToGson(list: List<SpokenLanguage>):String{
        return Gson().toJson(list)
    }
}