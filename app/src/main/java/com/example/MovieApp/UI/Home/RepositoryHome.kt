package com.example.MovieApp.UI.Home

import androidx.lifecycle.MutableLiveData
import com.example.MovieApp.DataLocal.MyDataBase
import com.example.MovieApp.Model.MovieModel
import com.example.MovieApp.Model.Result
import com.example.MovieApp.Network.RetroConnect
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryHome(){

  suspend  fun getMovieRemote():List<Result>{

      return try {
          val data=  RetroConnect.apiService.getMovie()
          insertMovies(data.results)
          data.results

      }catch (e:Exception){
          getMovieLocal()
      }


    }
 private suspend fun getMovieLocal()= MyDataBase.getDataBase()?.getDaoMovie()?.getAllMovies()!!

 private suspend fun insertMovies(list: List<Result>?)= list?.let {
     MyDataBase.getDataBase()?.getDaoMovie()?.insertMovies(it)
 }

}