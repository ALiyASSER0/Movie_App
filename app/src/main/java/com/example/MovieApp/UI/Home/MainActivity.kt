package com.example.MovieApp.UI.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.MovieApp.Adapter.MyAdapterMovies
import com.example.MovieApp.UI.Detials.DetialsActivity
import com.example.apicall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     var _binding:ActivityMainBinding?=null
    val binding get() = _binding!!
    lateinit var myAdapter :MyAdapterMovies
    private  val viewModelMainActivity: ViewModelMainActivity by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        navToPageDetials()
        observers()
    viewModelMainActivity.getMovies()
    }


    fun observers(){
        viewModelMainActivity.movieLiveData.observe(this){
            myAdapter.list=it
            binding.Rec.adapter=myAdapter

        }
    }
    fun navToPageDetials(){
        myAdapter=MyAdapterMovies{
            var intent=Intent(this,DetialsActivity::class.java)
            intent.putExtra("id","$it")
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}




