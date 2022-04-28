package com.coufie.chapterenammu1.kedua.listfilm

import com.coufie.challengechapterfive.model.GetFilmDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("apifilm.php")
    fun getAllFilm() : Call<List<GetFilmDataItem>>
}
