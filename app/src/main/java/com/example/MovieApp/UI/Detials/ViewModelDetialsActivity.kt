package com.example.MovieApp.UI.Detials

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.MovieApp.Model.DetialsMovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewModelDetialsActivity : ViewModel() {
  private  var _liveData=MutableLiveData<DetialsMovieModel>()
   val liveData get() = _liveData
    var repo=RepositoryDetials()



fun getDetialsMovie(id:Int){

    viewModelScope.launch(Dispatchers.IO) {
        _liveData.postValue(repo.getDetialsMovie(id))
    }


}


}