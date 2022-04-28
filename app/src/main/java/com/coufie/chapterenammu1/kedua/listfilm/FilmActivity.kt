package com.coufie.chapterenammu1.kedua.listfilm

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.challengechapterfive.model.GetFilmDataItem
import com.coufie.chapterenammu1.R
import kotlinx.android.synthetic.main.activity_film.*

class FilmActivity : AppCompatActivity() {

    lateinit var adapterfilm : FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

//        initRecycler()
//        getDataFilm()

        asyncFilm().execute()

    }

    inner class asyncFilm : AsyncTask<Void, Void, Void>(){

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            initRecycler()
            return null
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }
        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            getDataFilm()
        }
    }

    fun initRecycler(){

        rv_film.layoutManager = LinearLayoutManager(this)
        adapterfilm = FilmAdapter()
        rv_film.adapter = adapterfilm


    }

    fun getDataFilm(){
        val viewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        viewModel.getFilmLLD().observe(this, Observer {
            if(it != null){
                adapterfilm.setDataFilmLFA(it)
                adapterfilm.notifyDataSetChanged()
            }
        })
        viewModel.callFilmApi()
    }
}