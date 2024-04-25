package com.example.MovieApp.DataLocal.Converters

import androidx.room.TypeConverter
import com.example.MovieApp.Model.BelongsToCollection
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class BelongsToCollectionConverter {
    @TypeConverter
    fun fromString(value:String?):BelongsToCollection?{
        val listType: Type =object : TypeToken<BelongsToCollection>(){}.type

        return Gson().fromJson(value,listType)

    }
    @TypeConverter
    fun fromArrayToGson(list: BelongsToCollection?):String?{
        return Gson().toJson(list)
    }
}