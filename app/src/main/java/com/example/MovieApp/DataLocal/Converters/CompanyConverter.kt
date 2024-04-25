package com.example.MovieApp.DataLocal.Converters

import androidx.room.TypeConverter
import com.example.MovieApp.Model.ProductionCompany
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CompanyConverter {

    @TypeConverter
    fun fromString(value:String):List<ProductionCompany>{
        val listType: Type =object :TypeToken<List<ProductionCompany>>(){}.type

        return Gson().fromJson(value,listType)

    }
    @TypeConverter
    fun fromArrayToGson(list: List<ProductionCompany>):String{
        return Gson().toJson(list)
    }

}