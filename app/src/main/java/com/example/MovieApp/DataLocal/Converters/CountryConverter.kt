package com.example.MovieApp.DataLocal.Converters

import androidx.room.TypeConverter
import com.example.MovieApp.Model.ProductionCountry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CountryConverter {



    @TypeConverter
    fun fromString(value:String):List<ProductionCountry>{
        val listType: Type =object :TypeToken<List<ProductionCountry>>(){}.type

        return Gson().fromJson(value,listType)

    }
    @TypeConverter
    fun fromArrayToGson(list: List<ProductionCountry>):String{
        return Gson().toJson(list)
    }

}