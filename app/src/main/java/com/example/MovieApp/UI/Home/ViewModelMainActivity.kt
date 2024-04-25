package com.example.MovieApp.UI.Home
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.MovieApp.Model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewModelMainActivity: ViewModel() {

    private var _movieLiveData= MutableLiveData<List<Result>>()
  val  movieLiveData get() = _movieLiveData

    var repo= RepositoryHome()



 fun getMovies(){
     viewModelScope.launch(Dispatchers.IO) {
       val data=  repo.getMovieRemote()
         _movieLiveData.postValue(data)
     }

 }

}