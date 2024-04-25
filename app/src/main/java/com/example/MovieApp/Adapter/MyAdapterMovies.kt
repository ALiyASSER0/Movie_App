package com.example.MovieApp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.MovieApp.Const
import com.example.MovieApp.Model.Result
import com.example.apicall.databinding.HolderMovieBinding

class MyAdapterMovies(var Id:(Int)->Unit): RecyclerView.Adapter<MyAdapterMovies.MyViewHolder>() {

     var list:List<Result>?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view= HolderMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(list?.get(position))


    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

   inner class MyViewHolder(private val binding:HolderMovieBinding):ViewHolder(binding.root){
        private var bining=this.binding
init {
    itemView.setOnClickListener {
        list!!.get(layoutPosition).id?.let { it1 -> Id.invoke(it1) }
    }
}
        fun bind(modelMovie:Result?){
Glide.with(itemView.context).load(Const.BASE_IMAGE_UIL+modelMovie?.poster_path).into(binding.imageView)
      bining.textTitle.text=modelMovie?.title
        }

    }
}
