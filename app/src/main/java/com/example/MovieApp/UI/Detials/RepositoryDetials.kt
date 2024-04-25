package com.example.MovieApp.UI.Detials

import com.example.MovieApp.DataLocal.MyDataBase.Companion.getDataBase
import com.example.MovieApp.Model.DetialsMovieModel
import com.example.MovieApp.Network.RetroConnect

class RepositoryDetials {
    suspend fun getDetialsMovie(id:Int):DetialsMovieModel?{

        return try {
            val data = RetroConnect.apiService.getDetialsMovie(id)
            insertDetialsMovie(data)
            data
        }catch (e:Exception){
            getAllDetialsMovie()
        }


    }
  private suspend fun insertDetialsMovie(list: DetialsMovieModel?){
      list?.let { getDataBase()?.getDaoDetials()?.insertDetialsMovies(it) }
    }
  private suspend fun getAllDetialsMovie():DetialsMovieModel? {
      return getDataBase()?.getDaoDetials()?.getAllDetialsMovies()
   }
}