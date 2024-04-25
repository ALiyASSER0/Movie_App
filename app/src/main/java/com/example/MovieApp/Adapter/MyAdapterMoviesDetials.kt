package com.example.MovieApp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.MovieApp.Model.Genre
import com.example.MovieApp.Model.MovieModel
import com.example.apicall.databinding.HolderMovieDetialsBinding

class MyAdapterMoviesDetials(): RecyclerView.Adapter<MyAdapterMoviesDetials.MyViewH>() {

    var list2: List<Genre> ?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewH {
       var binding=HolderMovieDetialsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewH(binding)
    }

    override fun onBindViewHolder(holder: MyViewH, position: Int) {
       holder.bind(list2?.get(position))


    }

    override fun getItemCount(): Int {
       return list2?.size ?: 0
    }


inner class MyViewH(private val binding:HolderMovieDetialsBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(list: Genre?){
       list?.name.let {
           binding.txt.text=it
       }
    }

}
}
