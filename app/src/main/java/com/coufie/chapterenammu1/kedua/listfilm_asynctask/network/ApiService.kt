package com.coufie.chapterenammu1.kedua.listfilm_asynctask.network

import com.coufie.chapterenammu1.kedua.listfilm_asynctask.model.GetFilmDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("apifilm.php")
    fun getAllFilm() : Call<List<GetFilmDataItem>>
}
