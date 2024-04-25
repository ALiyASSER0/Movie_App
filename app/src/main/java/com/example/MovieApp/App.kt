package com.example.MovieApp

import android.app.Application
import com.example.MovieApp.DataLocal.MyDataBase

class App :Application() {
    override fun onCreate() {
        super.onCreate()
    MyDataBase.initDatabase(this)
    }
}