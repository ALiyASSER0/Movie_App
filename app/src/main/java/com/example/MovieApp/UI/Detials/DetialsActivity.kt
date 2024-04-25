package com.example.MovieApp.UI.Detials

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.MovieApp.Adapter.MyAdapterMoviesDetials
import com.example.MovieApp.Const
import com.example.MovieApp.Model.DetialsMovieModel
import com.example.MovieApp.UI.Home.MainActivity
import com.example.apicall.databinding.ActivityMovieDetialsBinding


class DetialsActivity : AppCompatActivity() {
     private var _binding:ActivityMovieDetialsBinding?=null
    val binding  get() = _binding!!
    val myAdapter2 by lazy { MyAdapterMoviesDetials() }
    val viewModel: ViewModelDetialsActivity by viewModels()
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       _binding=ActivityMovieDetialsBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        var id=intent.getStringExtra("id")
       observers()

      viewModel.getDetialsMovie(Integer.parseInt(id))



    }


    fun observers(){
        viewModel.liveData.observe(this){
            Glide.with(this).load(Const.BASE_IMAGE_UIL+it.backdrop_path).into(binding.imageView4)
            myAdapter2.list2=it.genres
            setTextView(it)
            btnBack()
            openBrowser(it)
            binding.recycle.adapter=myAdapter2
        }
    }
  fun openBrowser(detialsModel:DetialsMovieModel){
      var uri=detialsModel.homepage.toUri()
      binding.watch.setOnClickListener{
          val intent = Intent(Intent.ACTION_VIEW, uri)
          startActivity(intent)
      }
  }
fun setTextView(detialsModel:DetialsMovieModel){
    binding.apply {
        movieNameTxt.text=detialsModel.original_title
        movieStar.text= detialsModel.vote_average.toString()
        movieTime.text="${detialsModel.runtime} second"
        movieSummary.text=detialsModel.overview
    }
}
fun  btnBack(){
    binding.btnBack.setOnClickListener{
        onBackPressed()
    }
}
override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
    _binding=null
    }

}